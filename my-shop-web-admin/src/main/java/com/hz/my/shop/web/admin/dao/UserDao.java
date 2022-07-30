package com.hz.my.shop.web.admin.dao;

import com.hz.my.shop.domain.User;

/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 15:33
 * @Description: com.hz.my.shop.web.admin.dao
 * @version: 1.0
 */
public interface UserDao {
    /*
    根据邮箱和密码获取用户信息
     */
    public User getUser(String email,String password);
}
