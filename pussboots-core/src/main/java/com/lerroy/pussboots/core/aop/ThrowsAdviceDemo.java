/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/21.
 */
public class ThrowsAdviceDemo implements ThrowsAdvice {
    private static final Logger LOGGER = Logger.getLogger(ThrowsAdviceDemo.class.getName());

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        LOGGER.info("ThrowsAdviceDemo-method:" + method.getName() + " exception=" + ex);
    }
}