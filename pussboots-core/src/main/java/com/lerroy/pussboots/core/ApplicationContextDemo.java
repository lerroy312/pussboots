/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chunhong.pch on 17/7/10.
 */
public class ApplicationContextDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core-service.xml");
        Object object = context.getBean("aBean");
        System.out.println(object);
    }
}