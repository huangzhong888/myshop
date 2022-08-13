package com.hz.my.shop.commons.persistence;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/12 - 08 - 12 - 16:30
 * @Description: com.hz.my.shop.commons.persistence
 * @version: 1.0
 */
/*
所有业务逻辑层的基类
 */
public interface BaseService<T extends BaseEntity> {
    //查询用户表全部信息
    List<T> selectAll();

    //保存信息
    BaseResult save(T entity);

    //删除信息
    void delete(Long id);

    //根据id查询信息
    T getById(Long id);

    //更新信息
    void update(T entity);

    //批量删除
    void deleteMulti(String[] ids);

    //分页查询
    PageInfo<T> page(int start, int length, int draw, T entity);

    //查询总笔数
    int count(T entity);
}
