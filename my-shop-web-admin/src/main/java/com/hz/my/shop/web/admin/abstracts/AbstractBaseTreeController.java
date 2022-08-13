package com.hz.my.shop.web.admin.abstracts;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.persistence.BaseEntity;
import com.hz.my.shop.commons.persistence.BaseService;
import com.hz.my.shop.commons.persistence.BaseTreeEntity;
import com.hz.my.shop.commons.persistence.BaseTreeService;
import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 10:55
 * @Description: com.hz.my.shop.web.admin.abstracts
 * @version: 1.0
 */
public abstract class AbstractBaseTreeController<T extends BaseTreeEntity,S extends BaseTreeService<T>>{
    @Autowired
    protected S service;

    //跳转列表页
    public abstract String list(Model model);

    //跳转表单页
    public abstract String form(T entity);

    //保存
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);


    //删除
    public abstract BaseResult delete(String ids);


    /*
    新增内容时要选择类目，这里访问数据库处理后要拿到树形结构
     */
    public abstract List<T> treeData(Long id);

    /*
    内容分类列表的排序
     */
    protected void sortList(List<T> sourceList,List<T> targetList,Long parentId){
        for (T sourceEntity : sourceList) {
            if(sourceEntity.getParent().getId().equals(parentId)){
                targetList.add(sourceEntity);

                //判断有没有子节点，如有有则继续追加
                if(sourceEntity.getIsParent()){
                    for (T currentEntity : sourceList) {
                        if(currentEntity.getParent().getId().equals(sourceEntity.getId())){
                            sortList(sourceList,targetList,sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
