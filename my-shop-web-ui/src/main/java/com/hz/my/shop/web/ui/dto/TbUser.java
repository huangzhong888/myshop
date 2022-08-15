package com.hz.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 13:39
 * @Description: com.hz.my.shop.web.ui.dto
 * @version: 1.0
 */

@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
