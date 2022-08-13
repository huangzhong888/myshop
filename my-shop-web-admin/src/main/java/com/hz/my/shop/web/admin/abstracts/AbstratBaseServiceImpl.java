package com.hz.my.shop.web.admin.abstracts;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.persistence.BaseDao;
import com.hz.my.shop.commons.persistence.BaseEntity;
import com.hz.my.shop.commons.persistence.BaseService;
import com.hz.my.shop.domain.TbContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/12 - 08 - 12 - 22:29
 * @Description: com.hz.my.shop.web.admin.abstracts
 * @version: 1.0
 */
public abstract class AbstratBaseServiceImpl<T extends BaseEntity,D extends BaseDao> implements BaseService<T> {

    @Autowired
    protected D dao;

    //查询全部数据
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    //删除信息
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    //根据id查询信息
    @Override
    public T getById(Long id) {
        return (T)dao.getById(id);
    }

    //更新信息
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    //批量删除
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }


    //查询总笔数
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }

    @Override
    //分页查询
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));
        System.out.println(pageInfo);

        return pageInfo;
    }
}
