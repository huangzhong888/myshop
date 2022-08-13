package com.hz.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hz.my.shop.commons.persistence.BaseEntity;
import com.hz.my.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * @Auther: huangzhong
 * @Date: 2022/8/9 - 08 - 09 - 19:12
 * @Description: com.hz.my.shop.domain
 * @version: 1.0
 */
@Data
public class TbContentCategory extends BaseTreeEntity {
    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
