package com.hz.my.shop.commons.persistence;

import com.hz.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/12 - 08 - 12 - 20:42
 * @Description: com.hz.my.shop.commons.persistence
 * @version: 1.0
 */

//业务逻辑层通用的树形结构接口
public interface BaseTreeService<T extends BaseEntity> {
    /*
  查询全部信息
   */
    List<T> selectAll();

    /*
    保存
     */
    BaseResult save(T entity);

    //删除
    void delete(Long id);

    //查询id查询
    T getById(Long id);

    //更新信息
    void  update(T entity);

    //根据父级节点id查询所有子节点
    List<T> selectByPid(Long pid);
}
