/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by chunhong.pch on 18/4/8.
 */
public class DiscardPolicyDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardPolicy());

        EXECUTOR.submit(new Runnable() {
            @Override public void run() {
                try {
                    System.out.println("1111111111");
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        EXECUTOR.submit(new Runnable() {
            @Override public void run() {
                try {
                    System.out.println("2222222222");
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}