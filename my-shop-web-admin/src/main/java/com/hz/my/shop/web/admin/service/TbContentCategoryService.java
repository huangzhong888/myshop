package com.hz.my.shop.web.admin.service;

import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.web.admin.dao.TbContentCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/9 - 08 - 09 - 19:22
 * @Description: com.hz.my.shop.web.admin.service
 * @version: 1.0
 */

public interface TbContentCategoryService {

    List<TbContentCategory> selectAll();

    //根据父级节点id查询所有子节点
    List<TbContentCategory> selectByPid(Long pid);

    /**
     * 根据 ID 获取信息
     * @param id
     * @return
     */
    TbContentCategory getById(Long id);
}
