package com.hz.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/14 - 08 - 14 - 22:55
 * @Description: com.hz.my.shop.web.ui.controller
 * @version: 1.0
 */

// 注册控制器
@Controller
public class RegisterController {
    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}
