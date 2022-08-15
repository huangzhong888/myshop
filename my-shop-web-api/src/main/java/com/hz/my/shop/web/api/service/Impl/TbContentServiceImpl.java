package com.hz.my.shop.web.api.service.Impl;

import com.hz.my.shop.domain.TbContent;
import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.web.api.dao.TbContentDao;
import com.hz.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 21:27
 * @Description: com.hz.my.shop.web.api.service.Impl
 * @version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);

        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);

        return tbContentDao.selectByCategoryId(tbContent);
    }
}
