/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.logindemo;

import org.apache.commons.lang.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by chunhong.pch on 17/6/14.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String sourceUrl = request.getRequestURL().toString();
        String sourceUri = request.getRequestURI();
        if (StringUtils.equals("/login", sourceUri)) {
            chain.doFilter(req, resp);
            return;
        }

        HttpSession session = request.getSession(false);
        String sourceQueryString = request.getQueryString();
        if (StringUtils.isNotBlank(sourceQueryString)) {
            sourceUrl += "?" + sourceQueryString;
        }
        sourceUrl = URLEncoder.encode(sourceUrl,"UTF-8");
        if (session == null) {
            response.sendRedirect("/login?goto=" + sourceUrl);
            return;
        }

        String user = (String) session.getAttribute("user");
        if (StringUtils.isBlank(user)) {
            response.sendRedirect("/login?goto=" + sourceUrl);
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
