/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.filterdemo;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class LogFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter " + filterConfig.getFilterName() + " init...");
        Enumeration<String> parameterNames = filterConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = filterConfig.getInitParameter(name);
            System.out.println("filter parameter name:" + name + " ,value:" + value);
        }
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String remoteAddr = servletRequest.getRemoteAddr();
        String url = httpServletRequest.getRequestURL().toString();
        String parameters = httpServletRequest.getQueryString();
        System.out.println(remoteAddr + " ---> " + url + " " + parameters);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("filter " + filterConfig.getFilterName() + " destroy...");
    }
}