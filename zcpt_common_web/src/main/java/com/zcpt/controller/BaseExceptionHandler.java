package com.zcpt.controller;

import com.zcpt.entity.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData error(Exception e){
        e.printStackTrace();
        return new ResponseData(500 , e.getMessage());
    }
}
