package com.hz.my.shop.web.admin.service.impl;

import com.hz.my.shop.domain.User;
import com.hz.my.shop.web.admin.dao.UserDao;
import com.hz.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 16:19
 * @Description: com.hz.my.shop.web.admin.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String email, String password) {
        return userDao.getUser(email,password);
    }
}
