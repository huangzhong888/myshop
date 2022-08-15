package com.hz.my.shop.web.api.service;

import com.hz.my.shop.domain.TbUser;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 12:25
 * @Description: com.hz.my.shop.web.api.service
 * @version: 1.0
 */
public interface TbUserService {

    //登录
    TbUser login(TbUser tbUser);
}
