package com.zcpt.entity;

public enum ResponseCode {
    SUCCESS(200,"Success"),
    REQUESTBAD(400,"Bad Request"),
    NOTFOUND(404,"Not Found"),
    FORBIDDEN(403,"Forbidden"),
    SERVERERROR(500,"Server Internal Error"),
    UNAUTHORIZED(401,"unauthorized"),
    CUSTOMEERROR(700,"Custome Error");

    private final int code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code= code;
        this.desc =desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
