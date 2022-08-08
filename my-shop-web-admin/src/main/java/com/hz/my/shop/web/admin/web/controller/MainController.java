package com.hz.my.shop.web.admin.web.controller;

import com.hz.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 16:23
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */
@Controller
public class MainController {
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";
    }

}
