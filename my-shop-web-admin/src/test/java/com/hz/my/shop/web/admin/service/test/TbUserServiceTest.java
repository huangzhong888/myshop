package com.hz.my.shop.web.admin.service.test;

import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/1 - 08 - 01 - 19:14
 * @Description: com.hz.my.shop.web.admin.service.test
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;
    @Test
    public void selectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public void insert(){
        TbUser tbuser = new TbUser();
        tbuser.setUsername("Lusifer");
        tbuser.setPhone("15888888888");
        tbuser.setEmail("lusifer@funtl.com");
        tbuser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbuser.setCreated(new Date());
        tbuser.setUpdated(new Date());
        tbUserService.save(tbuser);
    }
    @Test
    public void delete(){
        tbUserService.delete(39L);
    }
    @Test
    public void selectOne(){
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser);
    }
    @Test
    public void update(){
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("lusifer");
        tbUserService.update(tbUser);
    }

    @Test
    public void md5(){
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
    }
}
