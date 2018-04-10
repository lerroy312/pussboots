/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by chunhong.pch on 17/8/8.
 */
public class CountDownLatchDemo {
    
    public static void main(String[] args) {
        Random random = new Random();
        int nThreads = 4;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch stopLatch = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            //同时发起n个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //等待startLatch.countDown为0时才返回，否则一直阻塞
                        startLatch.await();
                        System.out.println("thread " + Thread.currentThread().getName()
                                           + " start running,currentTimeMillis="
                                           + System.currentTimeMillis());
                        Thread.sleep(random.nextInt(100));
                        System.out.println("thread " + Thread.currentThread().getName()
                                           + " run completed,currentTimeMillis="
                                           + System.currentTimeMillis());
                        stopLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //latch减1，模拟n个线程同时起跑
        startLatch.countDown();

        try {
            //等待stopLatch的n个线程运行完毕
            stopLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}