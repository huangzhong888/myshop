package com.hz.my.shop.web.admin.service.impl;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.validator.BeanValidator;
import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.hz.my.shop.web.admin.dao.TbContentCategoryDao;
import com.hz.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import java.util.Date;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/9 - 08 - 09 - 19:25
 * @Description: com.hz.my.shop.web.admin.service.impl
 * @version: 1.0
 */
@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService {

    @Override
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if(validator!=null){
            return BaseResult.fail(validator);
        }
        else {
            TbContentCategory parent = entity.getParent();
            //如果没有选择父级节点，则默认设置为根目录
            if(parent == null||parent.getId() == null){
                //0代表根目录
                parent.setId(0L);
            }
            entity.setUpdated(new Date());
            //新增
            if(entity.getId() == null){
                entity.setCreated(new Date());
                entity.setIsParent(false);

                //判断当前新增的有没有父级节点
                if(parent.getId() != 0L){
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if(currentCategoryParent != null){
                        //为父级节点设置isParent为true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }
                //父级节点为0表示为根目录
                else {
                    //根目录一定是父级目录
                    entity.setIsParent(true);
                }

                dao.insert(entity);
            }
            //修改
            else {
               update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }
}
