package com.hz.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/14 - 08 - 14 - 19:57
 * @Description: com.hz.my.shop.web.ui.dto
 * @version: 1.0
 */

@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
