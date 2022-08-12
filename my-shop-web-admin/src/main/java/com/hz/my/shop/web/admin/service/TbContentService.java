package com.hz.my.shop.web.admin.service;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.domain.TbContent;
import com.hz.my.shop.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/10 - 08 - 10 - 9:44
 * @Description: com.hz.my.shop.web.admin.service
 * @version: 1.0
 */

public interface TbContentService {

    /*
   查询全部内容
    */
    List<TbContent> selectAll();

    /*
    新增内容
     */
    BaseResult save(TbContent tbContent);

    //删除
    void delete(Long id);

    //根据id查询内容
    TbContent getById(Long id);

    //更新内容信息
    void  update(TbContent tbContent);

    //批量删除
    void deleteMulti(String[] ids);

    //分页查询
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    //查询总笔数
    int count(TbContent tbContent);
}
