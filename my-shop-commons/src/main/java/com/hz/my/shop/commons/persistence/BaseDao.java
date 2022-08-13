package com.hz.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/12 - 08 - 12 - 16:16
 * @Description: com.hz.my.shop.commons.persistence
 * @version: 1.0
 */

//所有数据访问层的基类
public interface BaseDao<T extends BaseEntity> {
    /*
   查询全部信息
    */
    List<T> selectAll();

    /*
    新增
     */
    void insert(T entity);

    //删除
    void delete(Long id);

    //查询单个
    T getById(Long id);

    //更新信息
    void  update(T entity);

    //批量删除
    void deleteMulti(String[] ids);

    //分页查询
    List<T> page(Map<String,Object> params);

    //查询总笔数
    int count(T entity);
}
