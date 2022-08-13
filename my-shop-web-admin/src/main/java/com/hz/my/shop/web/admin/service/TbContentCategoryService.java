package com.hz.my.shop.web.admin.service;

import com.hz.my.shop.commons.persistence.BaseService;
import com.hz.my.shop.commons.persistence.BaseTreeService;
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

public interface TbContentCategoryService extends BaseTreeService<TbContentCategory> {

}
