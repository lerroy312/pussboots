/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chunhong.pch on 17/7/13.
 */
public class MethodInterceptorDemoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core-service.xml");
        AopService aopService = (AopService) context.getBean("aopService");
        aopService.fun();
    }
}