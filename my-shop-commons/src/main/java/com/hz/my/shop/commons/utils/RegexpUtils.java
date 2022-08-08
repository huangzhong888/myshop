package com.hz.my.shop.commons.utils;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/3 - 08 - 03 - 20:38
 * @Description: com.hz.my.shop.commons.utils
 * @version: 1.0
 */
public class RegexpUtils {
        /**
         * 验证手机号
         */
        public static final String PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

        /**
         * 验证邮箱地址
         */
        public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

        /**
         * 验证手机号
         * @param phone
         * @return
         */
        public static boolean checkPhone(String phone) {
            return phone.matches(PHONE);
        }

        /**
         * 验证邮箱
         * @param email
         * @return
         */
        public static boolean checkEmail(String email) {
            return email.matches(EMAIL);
        }
    }