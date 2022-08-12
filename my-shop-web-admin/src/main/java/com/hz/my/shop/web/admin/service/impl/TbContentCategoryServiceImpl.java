package com.hz.my.shop.web.admin.service.impl;

import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.web.admin.dao.TbContentCategoryDao;
import com.hz.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/9 - 08 - 09 - 19:25
 * @Description: com.hz.my.shop.web.admin.service.impl
 * @version: 1.0
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {

        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }
}
