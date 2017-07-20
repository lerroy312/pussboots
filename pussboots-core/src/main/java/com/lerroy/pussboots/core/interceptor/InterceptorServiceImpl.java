/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.interceptor;

import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/13.
 */
public class InterceptorServiceImpl implements InterceptorService {
    private static final Logger LOGGER  = Logger.getLogger(InterceptorServiceImpl.class.getName());
    @Override
    public void fun() {
        LOGGER.info("enter InterceptorServiceImpl.fun");
    }
}