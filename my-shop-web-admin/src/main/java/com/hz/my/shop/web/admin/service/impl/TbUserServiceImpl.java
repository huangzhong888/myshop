package com.hz.my.shop.web.admin.service.impl;
import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.utils.RegexpUtils;
import com.hz.my.shop.commons.validator.BeanValidator;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.abstracts.AbstratBaseServiceImpl;
import com.hz.my.shop.web.admin.dao.TbUserDao;
import com.hz.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/1 - 08 - 01 - 17:43
 * @Description: com.hz.my.shop.web.admin.service.impl
 * @version: 1.0
 */
@Service
public class TbUserServiceImpl extends AbstratBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            tbUser.setUpdated(new Date());
            //新增
            if (tbUser.getId() == null) {
                //密码需要加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }
            //修改编辑用户
            else {
                update(tbUser);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);
        if (tbUser != null) {
            //明文密码加密
            String md5password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后的密码是否和数据库的密码匹配
            if (md5password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }
}