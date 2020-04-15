package com.zcpt.utils;

import com.alibaba.fastjson.JSON;
import com.zcpt.entity.ResponseData;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//token问题
public class HeaderTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ResponseData responseData = null;
        String token = request.getHeader("token");
        if (!request.getRequestURI().contains("login") && !request.getRequestURI().contains("doc.html")) {
            if (token == null) {
                responseData = ResponseData.cusstomerError("用户认证不通过");
            }
            //如果token存在 则进行验证和更新  对token进行续期
            try {
                token = JWTUtils.updateToken(token);
            } catch (Exception e) {
                //token验证错误
                responseData = ResponseData.serverInternalError();
            }


        }
        if (responseData != null) {// 如果有错误信息
            response.getWriter().write(JSON.toJSONString(responseData));
            return false;
        } else {
            //认证通过  将token加入页面你的header 返回
            response.setHeader("token", token);
            return true;
        }
    }
}
