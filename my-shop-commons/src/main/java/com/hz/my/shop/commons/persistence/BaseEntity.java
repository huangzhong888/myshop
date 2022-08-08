package com.hz.my.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/7 - 08 - 07 - 9:49
 * @Description: com.hz.my.shop.commons.persistence
 * @version: 1.0
 */

    /*
    实体类的基类
     */
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
