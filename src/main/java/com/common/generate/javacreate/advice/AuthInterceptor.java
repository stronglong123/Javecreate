/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.advice;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.enums.BusinessCodeEnum;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.service.UserLoginInfoService;
import com.common.generate.javacreate.utils.UserInfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserLoginInfoService userService;
    @Autowired
    private UserInfoUtils userInfoUtils;

    private final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("进入拦截器URI:{},参数：{}", JSON.toJSONString(request.getRequestURI()), JSON.toJSONString(request
                .getParameterMap()));
        //请求路径
        String uri = request.getRequestURI();
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        //类路径
        String className = handlerMethod.getBean().getClass().getName();

        log.info("请求类路径:" + className);
//        if (className.contains("UserLoginInfoController") || className.contains("ExportExcelController")
//                || uri.contains("registerUser") || uri.contains("syncProductImg") || uri.contains("identifyingCode")
//                || uri.contains("validateCode") || className.contains("GeeTestLoginController")
//                || uri.contains("getImageCode") || className.contains("OpenAuthorizationController")) {
//            return true;
//        }

        if (this.ignoreInterceptor(handlerMethod)) {
            return true;
        }

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException(BusinessCodeEnum.ERROR_TOKEN.getText());
        }
        log.info("当前拦截 token：{}", token);
        // 通过token获取用户ID
        AdminUser userInfo = userService.getUserInfoByToken(token);
        if (null == userInfo) {
            throw new BusinessValidateException(BusinessCodeEnum.LOGIN_OUT_TIME.getText());
        } else {
            userService.setLoginToken(token, userInfo);
            userInfoUtils.setUserInfo(userInfo);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) {
    }


    private boolean ignoreInterceptor(HandlerMethod handlerMethod) {
        // 判断是否有IgnoreAuthInterceptor注解
        IgnoreAuthInterceptor ignoreAuthInterceptor = handlerMethod.getMethodAnnotation(IgnoreAuthInterceptor.class);
        if (null != ignoreAuthInterceptor) {
            return true;
        }

        ignoreAuthInterceptor = handlerMethod.getMethod().getDeclaringClass().getAnnotation(IgnoreAuthInterceptor.class);
        if (null != ignoreAuthInterceptor) {
            return true;
        }
        return false;
    }
}
