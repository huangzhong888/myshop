package com.hz.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 22:25
 * @Description: com.hz.my.shop.web.api.web.dto
 * @version: 1.0
 */

//内容数据传输对象
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
