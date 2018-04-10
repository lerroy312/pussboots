/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by chunhong.pch on 17/8/13.
 */
public class SynchronizedDemo {
    private static final Random RANDOM = new Random();

    public static void fun(){
        System.out.println("enter fun...");
        try {
            Thread.sleep(RANDOM.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("out fun");
    }

    /**
     * 在静态方法上使用synchronized，则锁住的是整个类，也就是不管SynchronizedDemo new
     * 多少个对象，同一时刻，该方法只有一个线程进入，因此严重影响并发性
     */
    public static synchronized void synchronizedOnStaticMethod() {
        //因为锁住了整个类，如下两行日志，只会严格交替出现
        fun();
    }

    public static void testSynchronizedOnStaticMethod() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    synchronizedOnStaticMethod();
                }
            });
        }
    }

    /**
     * 在普通方法上使用synchronized，则锁住的是本对象。如果多个线程，在不同的对象上调用本方法，则不起作用
     */
    public synchronized void synchronizedOnMethod() {
        fun();
    }

    public static void testSynchronizedOnMethod(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SynchronizedDemo demo1 = new SynchronizedDemo();
        List<Future<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new Callable<Void>() {
                @Override public Void call() throws Exception {
                    demo1.synchronizedOnMethod();
                    return null;
                }
            }));
        }
        //等待上面10个任务执行完毕，同样fun日志只会严格交替出现
        for(Future<Void> future : futures){
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        
        System.out.println("------------------------");
        //下面是在两个不同对象上调用同步方法，所以日志会无顺序，达不到同步效果
        SynchronizedDemo demo2 = new SynchronizedDemo();
        for (int i = 0; i < 20; i++) {
            int n = i;
            executorService.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    if (n % 2 == 0) {
                        demo1.synchronizedOnMethod();
                    } else {
                        demo2.synchronizedOnMethod();
                    }
                    return null;
                }
            });
        }
        
    }

    /**
     * 同步代码块:可以缩小锁定范围，提高并发度
     */
    public void synchronizedOnBlock(){
        synchronized (this){
            fun();
        }
    }

    public static void main(String[] args) {
        //testSynchronizedOnStaticMethod();
        testSynchronizedOnMethod();
    }
}