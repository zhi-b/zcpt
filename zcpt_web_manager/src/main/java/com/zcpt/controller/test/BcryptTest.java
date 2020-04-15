package com.zcpt.controller.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.realname.IUserService;

public class BcryptTest {
    @Reference
    private IUserService userService;

    public static void main (String[] args){
//        //获取盐
//        // 获取盐  $2a$10$JpefEQ1NKizv.5cW35ZLGu   $2a$10$W.sr/P/hMjJb40lViHUg2.
//        String salt =  BCrypt.gensalt();//29个字符  随机生成
//        System.out.println(salt);
//        String pass = BCrypt.hashpw("33",salt);
//        System.out.println(pass);

    }
    //
}