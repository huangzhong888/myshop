package com.hz.my.shop.web.api.service;

import com.hz.my.shop.domain.TbContent;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 21:25
 * @Description: com.hz.my.shop.web.api.service
 * @version: 1.0
 */
public interface TbContentService {

    //根据类别id查询内容列表
    List<TbContent> selectByCategoryId(Long categoryId);
}
