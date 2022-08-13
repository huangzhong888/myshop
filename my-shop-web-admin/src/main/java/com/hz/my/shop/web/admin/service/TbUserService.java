package com.hz.my.shop.web.admin.service;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.persistence.BaseService;
import com.hz.my.shop.domain.TbUser;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/1 - 08 - 01 - 17:42
 * @Description: com.hz.my.shop.web.admin.service
 * @version: 1.0
 */
public interface TbUserService extends BaseService<TbUser> {
    //用户登录
    TbUser login(String email,String password);
}
