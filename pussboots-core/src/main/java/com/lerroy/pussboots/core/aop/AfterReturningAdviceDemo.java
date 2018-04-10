/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/21.
 */
public class AfterReturningAdviceDemo implements AfterReturningAdvice {
    private static final Logger LOGGER = Logger.getLogger(AfterReturningAdviceDemo.class.getName());

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args,
                               Object target) throws Throwable {
        LOGGER.info("AfterReturningAdviceDemo-method:" + method.getName() + ",returnValue=" + returnValue);
    }
}