/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by chunhong.pch on 17/8/13.
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        final Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int n = i;
            executorService.submit(new Runnable() {
                @Override public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }

                    try {
                        System.out.println(String.format("thread id = %s, task id = %s start to run,",Thread.currentThread().getId(),n));
                            Thread.sleep(random.nextInt(100));
                        System.out.println(String.format("thread id = %s, task id = %s run completed,",Thread.currentThread().getId(),n));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }
    }



}