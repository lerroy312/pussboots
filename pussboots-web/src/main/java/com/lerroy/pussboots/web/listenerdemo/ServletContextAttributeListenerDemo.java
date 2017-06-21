/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.listenerdemo;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out
            .println("servlet context attribute name=" + name + ",value=" + value + "was added");
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out
            .println("servlet context attribute name=" + name + ",value=" + value + "was removed");
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out
            .println("servlet context attribute name=" + name + ",value=" + value + "was replaced");
    }
}