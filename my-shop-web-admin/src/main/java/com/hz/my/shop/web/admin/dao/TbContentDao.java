package com.hz.my.shop.web.admin.dao;

import com.hz.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/10 - 08 - 10 - 9:40
 * @Description: com.hz.my.shop.web.admin.dao
 * @version: 1.0
 */
@Repository
public interface TbContentDao {
    /*
    查询全部内容
     */
    List<TbContent> selectAll();

    /*
    新增内容
     */
    void insert(TbContent tbContent);

    //删除
    void delete(Long id);

    //根据id查询内容
    TbContent getById(Long id);

    //更新内容信息
    void  update(TbContent tbContent);

    //批量删除
    void deleteMulti(String[] ids);

    //分页查询
    List<TbContent> page(Map<String,Object> params);

    //查询总笔数
    int count(TbContent tbContent);
}
