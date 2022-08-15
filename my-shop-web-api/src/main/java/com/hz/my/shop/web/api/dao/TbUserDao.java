package com.hz.my.shop.web.api.dao;

import com.hz.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/14 - 08 - 14 - 23:03
 * @Description: com.hz.my.shop.web.api.dao
 * @version: 1.0
 */

//会员管理
@Repository
public interface TbUserDao {


    //登录
    TbUser login(TbUser tbUser);
}
