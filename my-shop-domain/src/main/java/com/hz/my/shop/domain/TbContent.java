package com.hz.my.shop.domain;

import com.hz.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/10 - 08 - 10 - 9:27
 * @Description: com.hz.my.shop.domain
 * @version: 1.0
 */

/*
内容管理
 */
@Data
public class TbContent extends BaseEntity {

    @Length(min = 1, max = 20, message = "标题长度介于 1 - 20 个字符之间")
    private String title;

    @Length(min = 1, max = 20, message = "子标题长度介于 1 - 20 个字符之间")
    private String subTitle;

    @Length(min = 1, max = 50, message = "标题描述长度介于 1 - 50 个字符之间")
    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1, message = "内容不能为空")
    private String content;

    //关联Tb_content_category表
    @NotNull(message = "父级类目不能为空")
    private TbContentCategory tbContentCategory;
}
