/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/21.
 */
public class MethodBeforeAdviceDemo implements MethodBeforeAdvice {
    private static final Logger LOGGER = Logger.getLogger(MethodBeforeAdviceDemo.class.getName());

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        LOGGER.info("MethodBeforeAdviceDemo-method:" + method.getName() + ",args=" + args);
    }
}