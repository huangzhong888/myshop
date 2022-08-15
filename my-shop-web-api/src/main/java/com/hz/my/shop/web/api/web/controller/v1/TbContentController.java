package com.hz.my.shop.web.api.web.controller.v1;

import com.hz.my.shop.commons.dto.BaseResult;
import com.hz.my.shop.domain.TbContent;
import com.hz.my.shop.domain.TbContentCategory;
import com.hz.my.shop.web.api.dao.TbContentDao;
import com.hz.my.shop.web.api.service.TbContentService;
import com.hz.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/13 - 08 - 13 - 21:31
 * @Description: com.hz.my.shop.web.api.web.controller
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if(id == null){
            tbContent = new TbContent();
        }
        return tbContent;
    }

    //幻灯片接口
    @RequestMapping(value = "ppt",method = RequestMethod.GET)
    public BaseResult findPPT(){
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(89L);

        if(tbContents != null && tbContents.size()>0){
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent,dto);
                tbContentDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",tbContentDTOS);
    }
}
