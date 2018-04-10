/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.aop;

import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/13.
 */
public class AopServiceImpl implements AopService {
    private static final Logger LOGGER = Logger.getLogger(AopServiceImpl.class.getName());

    @Override
    public void fun() {
        LOGGER.info("enter InterceptorServiceImpl.fun");
    }

    @Override
    public void funException() {
        throw new RuntimeException("----funException----");
    }

    @Override
    public void funPointCut() {
        LOGGER.info("enter AopServiceImpl.funPointCut");
    }
}