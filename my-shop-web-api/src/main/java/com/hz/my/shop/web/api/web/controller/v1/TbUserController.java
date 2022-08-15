package com.hz.my.shop.web.api.web.controller.v1;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.api.service.TbUserService;
import com.hz.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 12:37
 * @Description: com.hz.my.shop.web.api.web.controller.v1
 * @version: 1.0
 */

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 登录
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser){
        TbUser user = tbUserService.login(tbUser);

        if(user == null){
            return BaseResult.fail("账号或密码错误");
        }
        else {
            TbUserDTO dto = new TbUserDTO();
            BeanUtils.copyProperties(user,dto);
            return BaseResult.success("成功",dto);
        }

    }
}
