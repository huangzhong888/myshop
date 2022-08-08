package com.hz.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hz.my.shop.commons.persistence.BaseEntity;


/**
 * @Auther: huangzhong
 * @Date: 2022/8/1 - 08 - 01 - 17:30
 * @Description: com.hz.my.shop.domain
 * @version: 1.0
 */
public class TbUser extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
