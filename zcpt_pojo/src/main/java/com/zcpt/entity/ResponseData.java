package com.zcpt.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseData<T> implements Serializable {
//        对结果的消息描述
    private String message;
//        请求的状态码
    private int status;
//    相应数据
    private Map<String ,T>  data = new HashMap<>();

    public ResponseData putDataVule(String key,T value){
        data.put(key,value);
        return  this;
    }
    public ResponseData(int status,String message){
        this.status = status;
        this.message=message;
    }
    public static<T> ResponseData<T> success(){
        return  new ResponseData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public static<T> ResponseData<T> notFound(){
        return  new ResponseData(ResponseCode.NOTFOUND.getCode(),ResponseCode.NOTFOUND.getDesc());
    }
    public static<T> ResponseData<T> badRequest(){
        return  new ResponseData(ResponseCode.REQUESTBAD.getCode(),ResponseCode.REQUESTBAD.getDesc());
    }
    public static<T> ResponseData<T> forbidden(){
        return  new ResponseData(ResponseCode.FORBIDDEN.getCode(),ResponseCode.FORBIDDEN.getDesc());
    }
    public static<T> ResponseData<T> unauthorozed(){
        return  new ResponseData(ResponseCode.UNAUTHORIZED.getCode(),ResponseCode.UNAUTHORIZED.getDesc());
    }
    public static<T> ResponseData<T> serverInternalError(){
        return  new ResponseData(ResponseCode.SERVERERROR.getCode(),ResponseCode.SERVERERROR.getDesc());
    }
    public static<T> ResponseData<T> cusstomerError(String message){
        return  new ResponseData(ResponseCode.CUSTOMEERROR.getCode(),message);
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, T> getData() {
        return data;
    }
}
