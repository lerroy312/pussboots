/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.listenerdemo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class ServletRequestListenerDemo implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        System.out.println("http servlet request was initialized,request url="
                           + request.getRequestURL() + request.getQueryString());
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        System.out.println("http servlet request was destroyed,request url="
                           + request.getRequestURL() + request.getQueryString());
    }
}
