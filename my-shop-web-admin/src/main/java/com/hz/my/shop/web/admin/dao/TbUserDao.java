package com.hz.my.shop.web.admin.dao;

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
public interface TbUserDao {
    /*
    查询用户表全部信息
     */
     List<TbUser> selectAll();

    /*
    新增
     */
     void insert(TbUser tbUser);

     //删除
    void delete(Long id);

    //查询单个
    TbUser selectOne(Long id);

    //更新用户信息
    void  update(TbUser tbUser);

    //根据邮箱获取用户
    TbUser getByEmail(String email);

    //批量删除
    void deleteMulti(String[] ids);

    //分页查询
    List<TbUser> page(Map<String,Object> params);

    //查询总笔数
    int count(TbUser tbUser);
}
