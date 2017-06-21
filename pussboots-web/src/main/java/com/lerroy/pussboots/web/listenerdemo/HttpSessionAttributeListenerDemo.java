/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.listenerdemo;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out
                .println("http session attribute name=" + name + ",value=" + value + " was added");
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out
                .println("http session attribute name=" + name + ",value=" + value + " was removed");
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out
                .println("http session attribute name=" + name + ",value=" + value + " was replaced");
    }
}