package com.hz.my.shop.web.admin.abstracts;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.persistence.BaseEntity;
import com.hz.my.shop.commons.persistence.BaseService;
import com.hz.my.shop.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 10:10
 * @Description: com.hz.my.shop.web.admin.abstracts
 * @version: 1.0
 */

@Controller
public abstract class AbstractBaseController<T extends BaseEntity,S extends BaseService<T>> {

    //注入业务逻辑层
    @Autowired
    protected S service;

    //跳转到列表页
    public abstract String list();

    //跳转表单页
    public abstract String form();

    //保存提交的信息
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    //删除信息
    public abstract BaseResult delete(String ids);

    //分页查询
    public abstract PageInfo<T> page(HttpServletRequest request , T entity );

    //跳转详情页
    public abstract String detail();
}
