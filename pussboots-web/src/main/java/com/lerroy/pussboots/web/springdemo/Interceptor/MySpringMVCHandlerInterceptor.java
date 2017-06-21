/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.springdemo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chunhong.pch on 17/6/21.
 */
public class MySpringMVCHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        System.out.println("url:" + url + " pre handle");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURL().toString();
        System.out.println("url:" + url + " post handle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        String url = request.getRequestURL().toString();
        System.out.println("url:" + url + " post handle");
    }
}