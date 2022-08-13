package com.hz.my.shop.web.admin.abstracts;

import com.hz.my.shop.commons.persistence.BaseEntity;
import com.hz.my.shop.commons.persistence.BaseTreeDao;
import com.hz.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/12 - 08 - 12 - 21:02
 * @Description: com.hz.my.shop.web.admin.abstracts
 * @version: 1.0
 */
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao> implements BaseTreeService<T>{
    @Autowired
    protected D dao;

    /*
  查询全部信息
   */
   @Override
   public List<T> selectAll(){
       return dao.selectAll();
   };

    //删除
  @Override
  @Transactional(readOnly = false)
  public void delete(Long id){
      dao.delete(new String[]{String.valueOf(id)});
    };

    //查询id查询
    @Override
    public T getById(Long id){
        return (T)dao.getById(id);
    };

    //更新信息
    @Override
    @Transactional(readOnly = false)
    public void  update(T entity){
         dao.update(entity);
    };

    //根据父级节点id查询所有子节点
    @Override
    public List<T> selectByPid(Long pid){
        return dao.selectByPid(pid);
    };

}
