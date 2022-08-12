package com.hz.my.shop.web.admin.web.controller;

import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/9 - 08 - 09 - 19:27
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */
/*
内容分类管理
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;

        //id不为空，则从数据库获取
        if(id!=null){
            tbContentCategory = tbContentCategoryService.getById(id);
        }
        else{
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();
        sortList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }


    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_category_form";
    }

    /*
    新增内容时要选择类目，这里访问数据库处理后要拿到树形结构
     */
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if(id == null){
            id = 0L;
        }
        return tbContentCategoryService.selectByPid(id);
    }
    /*
    内容分类列表的排序
     */
    public void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for (TbContentCategory tbContentCategory : sourceList) {
            if(tbContentCategory.getParentId().equals(parentId)){
                targetList.add(tbContentCategory);

                //判断有没有子节点，如有有则继续追加
                if(tbContentCategory.isParent()){
                    for (TbContentCategory contentCategory : sourceList) {
                        if(contentCategory.getParentId().equals(tbContentCategory.getId())){
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
