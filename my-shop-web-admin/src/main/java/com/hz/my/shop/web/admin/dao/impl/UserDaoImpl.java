package com.hz.my.shop.web.admin.dao.impl;

import com.hz.my.shop.domain.User;
import com.hz.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 15:37
 * @Description: com.hz.my.shop.web.admin.dao.impl
 * @version: 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User getUser(String email, String password) {
        logger.debug("调用getUser(),email:{} password:{}",email,password);
        User user =null;
        if("admin@qq.com".equals(email)){
            if("admin".equals(password)){
                user = new User();
                user.setEmail("admin@qq.com");
                user.setUsername("huangzhong");

                logger.info("成功获取 \"{}\"的用户信息",user.getUsername());
            }
        }
        else {
            logger.warn("获取\"{}\"的用户信息失败",email);
        }
        return user;
    }
}
