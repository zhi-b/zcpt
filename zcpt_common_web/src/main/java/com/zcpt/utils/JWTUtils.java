package com.zcpt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JWTUtils {
    //    token 加密时候 使用密钥 一旦得到密钥 也就可以来伪造token
    public final static String sercetKey = "zcpt@no2";
    // token的有效时间
    public final static long keepTime = 1800000;
    /**JWT的Token的组成
     * Head  使用base64 进行编码之后得到信息
     * 载荷 Payload 一般是用户信息和声明
     * 签证Signature 一般密钥和签名
     *id 用户id
     * issuer 签发这
     * subject 用户名
     */
    public static String generToken(String id ,String issuer, String subject){
        long ttlMillis = keepTime;
        // 加密算法 Hash256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取系统时间 来设置token的有效时间
        long nowMillis  = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 将密钥转换为Base64形式 在转换为字节码
        byte[] apiKeySercetBytes =  DatatypeConverter.parseBase64Binary(sercetKey);
        // 对key进行采用hash256算法进行加密
        Key siginkey = new SecretKeySpec(apiKeySercetBytes,signatureAlgorithm.getJcaName());
        // JWT生成设置
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now);
        if(subject!= null){
            builder.setSubject(subject);
        }
        if(issuer != null){
            builder.setIssuer(issuer);
        }
        builder.signWith(signatureAlgorithm,siginkey);
        //检测toke的有效时间
        if(ttlMillis >=0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        //返回最终的token
        return builder.compact();
    }
    //更新token
    public static String updateToken(String token){
        Claims claims =verifyToken(token);
        String id = claims.getId();
        String subject = claims.getSubject();
        String issuer = claims.getIssuer();
        //重新生成token
        return  generToken(id,issuer,subject);
    }
    // 解析token
    private static Claims verifyToken(String token){
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(sercetKey))
                .parseClaimsJws(token).getBody();
        return  claims;
    }

}
