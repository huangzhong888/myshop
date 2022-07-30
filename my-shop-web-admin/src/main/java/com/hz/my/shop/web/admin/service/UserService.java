package com.hz.my.shop.web.admin.service;

import com.hz.my.shop.domain.User;

/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 16:17
 * @Description: com.hz.my.shop.web.admin.service
 * @version: 1.0
 */
public interface UserService {
    /*
    登录
     */
    public User login(String email,String password);
}
