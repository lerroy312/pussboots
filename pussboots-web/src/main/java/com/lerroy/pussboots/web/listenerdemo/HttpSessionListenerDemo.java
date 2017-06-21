/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.listenerdemo;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class HttpSessionListenerDemo implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        System.out.println("http session id = " + httpSession.getId() + " created");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        System.out.println("http session id = " + httpSession.getId() + " destroyed");
    }
}