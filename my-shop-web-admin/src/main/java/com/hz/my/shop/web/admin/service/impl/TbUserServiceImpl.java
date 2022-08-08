package com.hz.my.shop.web.admin.service.impl;
import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.utils.RegexpUtils;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.dao.TbUserDao;
import com.hz.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
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
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {

        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult1 = checkTbUser(tbUser);
        //通过验证
        if(baseResult1.getStatus()==BaseResult.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());
            //新增
            if(tbUser.getId()==null){
                //密码需要加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            //修改编辑用户
            else {
                tbUserDao.update(tbUser);
            }
            baseResult1.setMessage("保存用户信息成功");
        }
        return baseResult1;
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser selectOne(Long id) {
        return tbUserDao.selectOne(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if(tbUser!=null){
            //明文密码加密
            String md5password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后的密码是否和数据库的密码匹配
            if(md5password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser) {
        int count = tbUserDao.count(tbUser);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbUser",tbUser);

        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setDraw(start);
        pageInfo.setDraw(length);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(params));
        System.out.println(pageInfo);

        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

    /*
    用户信息的有效性验证
    非空验证、
     */
    public BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult = BaseResult.success();
        if(StringUtils.isBlank(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空请重新输入");
        }
        else if(!RegexpUtils.checkEmail(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱格式错误，请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getPassword())){
            baseResult = BaseResult.fail("密码不能为空请重新输入");
        }
        else if(StringUtils.isBlank(tbUser.getUsername())){
            baseResult = BaseResult.fail("姓名不能为空请重新输入");
        }
        else if(StringUtils.isBlank(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机号不能为空请重新输入");
        }
        else if(!RegexpUtils.checkPhone(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机格式错误，请重新输入");
        }
        return baseResult;
    }

}
