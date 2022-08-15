package com.hz.my.shop.web.api.dao;

import com.hz.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 21:03
 * @Description: com.hz.my.shop.web.api.dao
 * @version: 1.0
 */
@Repository
public interface TbContentDao {

    //根据类别id查询内容列表
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
