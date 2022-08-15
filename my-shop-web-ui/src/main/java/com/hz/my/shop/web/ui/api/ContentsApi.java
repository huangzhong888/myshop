package com.hz.my.shop.web.ui.api;

import com.hz.my.shop.commons.utils.HttpClientUtils;
import com.hz.my.shop.commons.utils.MapperUtils;
import com.hz.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/14 - 08 - 14 - 20:52
 * @Description: com.hz.my.shop.web.ui.api
 * @version: 1.0
 */

//内容管理接口
public class ContentsApi {

    //请求幻灯片
    public static List<TbContent> ppt(){
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
