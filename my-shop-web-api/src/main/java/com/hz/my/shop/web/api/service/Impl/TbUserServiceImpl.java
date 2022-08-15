package com.hz.my.shop.web.api.service.Impl;

import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.api.dao.TbUserDao;
import com.hz.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 12:26
 * @Description: com.hz.my.shop.web.api.service.Impl
 * @version: 1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);
        if(user != null){
            //将明文密码加密
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if(password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
