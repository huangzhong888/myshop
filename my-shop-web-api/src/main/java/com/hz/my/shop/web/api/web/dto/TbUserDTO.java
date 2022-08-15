package com.hz.my.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.security.PrivateKey;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 14:31
 * @Description: com.hz.my.shop.web.api.web.dto
 * @version: 1.0
 */

//会员数据传输对象
@Data
public class TbUserDTO implements Serializable {
    private Long  id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
