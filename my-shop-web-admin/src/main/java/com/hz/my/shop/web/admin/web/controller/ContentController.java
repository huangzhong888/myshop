package com.hz.my.shop.web.admin.web.controller;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.domain.TbContent;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/10 - 08 - 10 - 11:09
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */
/*
内容管理
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        //id不为空，则从数据库获取
        if(id!=null){
            tbContent = tbContentService.getById(id);
        }
        else{
            tbContent = new TbContent();
        }
        return tbContent;
    }

    //跳转到用户列表页
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "content_list";
    }

    //跳转表单页
    @RequestMapping(value = "form" ,method = RequestMethod.GET)
    public String form(){
        return "content_form";
    }
    //保存提交的内容信息
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbContentService.save(tbContent);
        //保存成功
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return "content_form";
        }
    }


    /*
    删除用户信息
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult ;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除内容成功");
        }
        else{
            baseResult = BaseResult.fail("删除内容失败");
        }

        System.out.println(ids);
        return baseResult;
    }

    /*
    分页查询
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request , TbContent tbcontent ){

        String strDraw = request.getParameter("draw");
        String strStart =  request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw==null?0:Integer.parseInt(strDraw);
        int start = strStart==null?0:Integer.parseInt(strStart);
        int length = strLength==null?10:Integer.parseInt(strLength);

        //封装dataTables需要的结果
        PageInfo<TbContent> pageInfo = tbContentService.page(start,length,draw,tbcontent);
        
        return pageInfo;
    }

    //显示详情
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbcontent){
        return "content_detail";
    }
}
