package com.hz.my.shop.commons.persistence;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/12 - 08 - 12 - 20:35
 * @Description: com.hz.my.shop.commons.persistence
 * @version: 1.0
 */

//数据访问层通用的树形结构接口
public interface BaseTreeDao<T extends BaseEntity> {
    /*
  查询全部信息
   */
    List<T> selectAll();

    /*
    新增
     */
    void insert(T entity);

    // 删除
    void delete(String[] ids);

    //查询id查询
    T getById(Long id);

    //更新信息
    void  update(T entity);

    //根据父级节点id查询所有子节点
    List<T> selectByPid(Long pid);

}
