/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.listenerdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class ServletContextListenerDemo implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String servletContextName = context.getServletContextName();
        System.out.println("servlet context name = "+servletContextName +" initialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String servletContextName = context.getServletContextName();
        System.out.println("servlet context name = "+servletContextName +" destroyed");
    }
}