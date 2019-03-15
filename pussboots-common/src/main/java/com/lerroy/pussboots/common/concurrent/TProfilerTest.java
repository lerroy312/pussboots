/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

/**
 * Created by chunhong.pch on 18/5/8.
 */
public class TProfilerTest {
    public static void fun1() throws InterruptedException {
        System.out.println("ssssss");
        Thread.sleep(1000);
    }


    public static void fun2() throws InterruptedException {
        System.out.println("ssssss");
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000000;i++){
            fun1();
            fun2();
        }
    }
}