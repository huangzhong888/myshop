package com.hz.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/11 - 08 - 11 - 16:30
 * @Description: com.hz.my.shop.web.admin.web.controller
 * @version: 1.0
 */

/*
文件上传控制器
 */
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";

    //文件上传
    /*
    dropFile:这是dropz的上传参数
    editorFile：这是wangEditor的上传参数
     */
    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile , MultipartFile editorFile,HttpServletRequest request ){
        Map<String,Object> result = new HashMap<>();

        //前端上传的文件
        MultipartFile myFile = dropFile == null ? editorFile : dropFile;

        //获取文件后缀
        String fileName = myFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        //文件存放路径
        String filePath =  request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        //判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }

        //将文件写入目标目录
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //dropz上传
        if(dropFile!=null){
            result.put("fileName",UPLOAD_PATH + file.getName());
        }
        //wangEditor上传
        else {
            /*
        scheme:服务端提供的协议http或者https
        serverName:服务器名称 localhost/ip/域名
        serverPort：服务器端口
         */
            String serverPath = request.getScheme() + "://" + request.getServerName() +":" + request.getServerPort();
            result.put("errno",0);
            result.put("data",new String[]{serverPath + UPLOAD_PATH + file.getName()});
        }
        return result;
    }
}
