package com.hz.my.shop.web.ui.api;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.utils.HttpClientUtils;
import com.hz.my.shop.commons.utils.MapperUtils;
import com.hz.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 13:35
 * @Description: com.hz.my.shop.web.ui.api
 * @version: 1.0
 */

//会员管理接口
public class UsersApi {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN,params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }
}
