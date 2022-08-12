package com.hz.my.shop.web.admin.dao;

import com.hz.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/9 - 08 - 09 - 19:20
 * @Description: com.hz.my.shop.web.admin.dao
 * @version: 1.0
 */

@Repository
public interface TbContentCategoryDao {

    List<TbContentCategory> selectAll();

    //根据父级节点id查询所有子节点
    List<TbContentCategory> selectByPid(Long pid);

    TbContentCategory getById(Long id);
}
