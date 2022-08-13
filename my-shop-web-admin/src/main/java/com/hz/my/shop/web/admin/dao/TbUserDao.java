package com.hz.my.shop.web.admin.dao;

import com.hz.my.shop.commons.persistence.BaseDao;
import com.hz.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/1 - 08 - 01 - 17:37
 * @Description: com.hz.my.shop.web.admin.dao
 * @version: 1.0
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    //根据邮箱获取用户
    TbUser getByEmail(String email);
}
