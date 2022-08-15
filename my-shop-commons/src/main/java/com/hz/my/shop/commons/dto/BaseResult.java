package com.hz.my.shop.commons.dto;

import java.io.Serializable;
import java.util.SplittableRandom;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/3 - 08 - 03 - 12:05
 * @Description: com.hz.my.shop.commons.dto
 * @version: 1.0
 */

/*
自定义返回结果
 */
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;
    private int status;
    private String message;
    private Object data;

    public static BaseResult success(){
      return createResult(STATUS_SUCCESS,"成功",null);
    }
    public static BaseResult success(String message){
        return createResult(STATUS_SUCCESS,message,null);
    }

    public static BaseResult fail(){
       return createResult(STATUS_FAIL,"失败",null);
    }

    public static BaseResult fail(String message){
        return createResult(STATUS_FAIL,message,null);
    }

    public static BaseResult fail(int status,String message){
        return createResult(status,message,null);
    }

    public static BaseResult success(String message,Object data){
        return BaseResult.createResult(STATUS_SUCCESS,message,data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static BaseResult createResult(int status, String message,Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
    @Override
    public String toString() {
        return "BaseResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
