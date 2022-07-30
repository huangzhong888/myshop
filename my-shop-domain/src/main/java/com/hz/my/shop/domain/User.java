package com.hz.my.shop.domain;

import com.sun.org.apache.xml.internal.serialize.Serializer;

import java.io.Serializable;

/**
 * @Auther: huangzhong
 * @Date: 2022/7/29 - 07 - 29 - 15:29
 * @Description: com.hz.my.shop.domain
 * @version: 1.0
 */
public class User implements Serializable {
    private String email;
    private String password;
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
