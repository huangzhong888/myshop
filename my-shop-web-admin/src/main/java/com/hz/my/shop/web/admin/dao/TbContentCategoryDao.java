package com.hz.my.shop.web.admin.dao;

import com.hz.my.shop.commons.persistence.BaseDao;
import com.hz.my.shop.commons.persistence.BaseTreeDao;
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
public interface TbContentCategoryDao extends BaseTreeDao<TbContentCategory> {

}
