package com.hz.my.shop.web.admin.service;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.domain.TbUser;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/1 - 08 - 01 - 17:42
 * @Description: com.hz.my.shop.web.admin.service
 * @version: 1.0
 */
public interface TbUserService {
    //查询用户表全部信息
    List<TbUser> selectAll();

    //保存用户信息
    BaseResult save(TbUser tbUser);

    //删除用户信息
    void delete(Long id);

    //根据id查询用户信息
    TbUser selectOne(Long id);

    //更新用户信息
    void update(TbUser tbUser);


   //用户登录
   TbUser login(String email,String password);

    //批量删除
    void deleteMulti(String[] ids);

    //分页查询
    PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser);

    //查询总笔数
    int count(TbUser tbUser);
}
