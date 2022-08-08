package com.hz.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/7 - 08 - 07 - 16:39
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}
