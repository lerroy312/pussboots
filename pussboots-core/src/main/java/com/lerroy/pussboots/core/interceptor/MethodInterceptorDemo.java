/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/13.
 */
public class MethodInterceptorDemo implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Logger logger = Logger.getLogger(MethodInterceptorDemo.class.getName());
        logger.info("method start:" + invocation.getMethod().getName());
        Object result = invocation.proceed();
        logger.info("method end:" + invocation.getMethod().getName() + ",result=" + result);
        return result;
    }
}