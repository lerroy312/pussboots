/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chunhong.pch on 17/8/13.
 */
public class CyclicBarrierDemo {
    private static final Random RANDOM = new Random();

    private static void normalTest(){
        int nThread = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(nThread);
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        for (int i = 0; i < nThread; i++) {
            int n = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                        System.out.println(String.format("task id = %s enter barrier A", n));
                        Thread.sleep(RANDOM.nextInt(100));
                        cyclicBarrier.await();
                        System.out.println(String.format("task id = %s enter barrier B", n));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            });
        }
    }

    private static void exceptionTest(){
        int nThread = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(nThread);
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        for (int i = 0; i < nThread; i++) {
            int n = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(n == 2){
                            throw new RuntimeException();
                        }
                        cyclicBarrier.await();
                        System.out.println(String.format("task id = %s enter barrier A", n));
                        Thread.sleep(RANDOM.nextInt(100));
                        cyclicBarrier.await();
                        System.out.println(String.format("task id = %s enter barrier B", n));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            });
        }
    }


    public static void main(String[] args) {
        //normalTest();
        exceptionTest();
    }
}