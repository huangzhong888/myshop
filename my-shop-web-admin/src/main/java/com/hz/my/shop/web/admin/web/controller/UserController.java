package com.hz.my.shop.web.admin.web.controller;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.abstracts.AbstractBaseController;
import com.hz.my.shop.web.admin.service.TbUserService;
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

/**
 * @Auther: huangzhong
 * @Date: 2022/8/2 - 08 - 02 - 20:41
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */

/*
用户管理
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<TbUser,TbUserService> {

    @ModelAttribute
    public TbUser getTbUsr(Long id){
        TbUser tbUser = null;
        //id不为空，则从数据库获取
        if(id!=null){
            tbUser = service.getById(id);
        }
        else{
            tbUser = new TbUser();
        }
        return tbUser;
    }

    //跳转到用户列表页
    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    //跳转用户表单页
    @Override
    @RequestMapping(value = "form" ,method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    //保存提交的用户信息
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.save(tbUser);
        //保存成功
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //保存失败
        else {
           model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }


    /*
    删除用户信息
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult ;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除数据成功");
        }
        else{
            baseResult = BaseResult.fail("删除失败");
        }

        System.out.println(ids);
        return baseResult;
    }

    /*
    分页查询
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request ,TbUser tbUser ){

        String strDraw = request.getParameter("draw");
        String strStart =  request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装dataTables需要的结果
        PageInfo<TbUser> pageInfo = service.page(start,length,draw,tbUser);
        return pageInfo;
    }

    //显示用户详情
    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(){
        return "user_detail";
    }

}
