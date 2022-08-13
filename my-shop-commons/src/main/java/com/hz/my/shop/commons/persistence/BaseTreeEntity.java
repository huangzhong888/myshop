package com.hz.my.shop.commons.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 11:27
 * @Description: com.hz.my.shop.commons.persistence
 * @version: 1.0
 */

@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
}
