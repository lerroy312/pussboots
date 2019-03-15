/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by chunhong.pch on 18/4/16.
 */
public class ThreadExecutorQueueSizeDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor defaultExecutor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1001));
        Random random = new Random();
        long begin = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(600);
        for (int i = 0; i < 600; i++) {
            final int index = i;
            defaultExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task:" + index);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("use:" + (end - begin) / 1000 + "s");
    }
}