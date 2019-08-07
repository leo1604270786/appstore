package com.ncu.appstore.dto;

import java.io.Serializable;
/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-07 16:11
 **/
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;
    private Object data;

    public static BaseResult success(){
        return new BaseResult(STATUS_SUCCESS,"成功");
    }
    public static BaseResult success(String message){
        return new BaseResult(STATUS_SUCCESS,message);
    }
    public static BaseResult success(String message,Object data){
        return new BaseResult(STATUS_SUCCESS,message,data);
    }
    public static BaseResult fail(){
        return new BaseResult(STATUS_FAIL,"失败");
    }
    public static BaseResult fail(String message){
        return new BaseResult(STATUS_FAIL,message);
    }
    public static BaseResult fail(int status, String message){
        return new BaseResult(status,message);
    }

    public BaseResult(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public BaseResult(int status, String message,Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
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
}