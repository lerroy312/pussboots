/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.listenerdemo;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by chunhong.pch on 17/6/14.
 */
public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
        System.out
            .println("servlet request attribute name = " + name + ",value=" + value + " was added");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
        System.out.println(
            "servlet request attribute name = " + name + ",value=" + value + " was removed");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
        System.out.println(
            "servlet request attribute name = " + name + ",value=" + value + " was replaced");
    }
}