/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.reflection;

/**
 * Created by chunhong.pch on 16/12/17.
 */
public class MyInterfaceImpl implements MyInterface {
    private String myFiled = "my default value";
    static {
        System.out.println("enter MyInterfaceImpl static");
    }

    public MyInterfaceImpl() {
    }

    public MyInterfaceImpl(String myFiled) {
        this.myFiled = myFiled;
    }

    @Override
    public int myMethod(String param) throws RuntimeException {
        System.out.println("enter my public method, param is " + param);
        return 0;
    }

    private String myPrivateMethod(String param) throws Exception {
        System.out.println("enter my private method, param is " + param);
        return "world";
    }

    @Override
    public String toString() {
        return "MyInterfaceImpl{" + "myFiled='" + myFiled + '\'' + '}';
    }
}