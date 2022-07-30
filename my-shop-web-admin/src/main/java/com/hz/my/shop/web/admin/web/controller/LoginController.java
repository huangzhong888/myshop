package com.hz.my.shop.web.admin.web.controller;

import com.hz.my.shop.commons.constant.ConstantUtils;
import com.hz.my.shop.domain.User;
import com.hz.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 16:22
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    /*
    该处理器处理请求
    跳转至登录页面
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){

        return "login";
    }
    /*
    登录逻辑
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest){
        User user = userService.login(email,password);

        //登录失败
        if(user == null){
            return "login";
        }
        //登录成功
        else {
            //将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }
    }
}
