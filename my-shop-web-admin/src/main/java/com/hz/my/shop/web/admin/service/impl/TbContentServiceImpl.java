package com.hz.my.shop.web.admin.service.impl;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.commons.dto.PageInfo;
import com.hz.my.shop.commons.utils.RegexpUtils;
import com.hz.my.shop.commons.validator.BeanValidator;
import com.hz.my.shop.domain.TbContent;
import com.hz.my.shop.domain.TbUser;
import com.hz.my.shop.web.admin.abstracts.AbstratBaseServiceImpl;
import com.hz.my.shop.web.admin.dao.TbContentDao;
import com.hz.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/10 - 08 - 10 - 9:45
 * @Description: com.hz.my.shop.web.admin.service.impl
 * @version: 1.0
 */
@Service
public class TbContentServiceImpl extends AbstratBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            tbContent.setUpdated(new Date());
            //新增
            if(tbContent.getId()==null){
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }
            //修改编辑用户
            else {
                update(tbContent);
            }
           return BaseResult.success("保存信息成功");
        }
    }

}
