/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chunhong.pch on 17/7/12.
 */
public class InvocationHandlerDemo implements InvocationHandler {
    public InvocationHandlerDemo(Object target) {
        this.target = target;
    }

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        UserService userService  = new UserServiceImpl();
        InvocationHandler invocationHandler = new InvocationHandlerDemo(userService);
        UserService userServiceProxy =  (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),new Class[]{UserService.class},invocationHandler);
        userServiceProxy.getAge();
        userServiceProxy.getName();
    }
}