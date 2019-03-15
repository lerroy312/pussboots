/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by chunhong.pch on 17/6/21.
 */
public class ThreadExecutorDemo {
    private static Random random = new Random(System.nanoTime());

    private static Runnable runnableDemo() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    String name = Thread.currentThread().getName();
                    long id = Thread.currentThread().getId();
                    System.out.println("thread name=" + name + ",id=" + id + " is running...");
                    Thread.sleep(random.nextInt(1000));
                    System.out.println("thread name=" + name + ",id=" + id + " run end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /**
     * 测试使用缓冲线程池
     * 缓冲线程池中的线程数是动态可调的
     * 当调用executorService.execute执行一个runnable时,如果池子中没有可用的线程,则会创建一个新线程来执行,并加到线程池中。
     * 如果有空闲的线程,则直接取空闲线程执行runnable
     * 当空闲线程超过有效期(默认60s),则销毁.
     * 如果没有可用线程,则会一直创建新线程,是不安全的。
     * 因此一般使用fixedThreadPool,固定线程池大小,如果没有可用线程,则在队列中排队执行
     */
    private static void cachedThreadPoolDemo() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //同时运行100000个任务,会因无法创建新线程而异常
        int nTasks = 100000;
        for (int i = 0; i < nTasks; i++) {
            executorService.execute(runnableDemo());
        }
    }

    /**
     *  带ThreadFactory的线程池,可以设置线程id,线程名,线程优先级等参数
     */
    private static void cachedThreadPoolWithThreadFactoryDemo() {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("MyThreadName");
                return thread;
            }
        });
        executorService.execute(runnableDemo());
    }

    /**
     * 固定大小的线程池
     * 任务在线程池中排队,如果池中无可用线程,则等待,否则就执行
     */
    private static void fixedThreadPoolDemo() {
        int nThread = 10;
        int nTask = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        for (int i = 0; i < nTask; i++) {
            //模拟提交10000个任务
            executorService.execute(runnableDemo());
        }
    }

    /**
     * 单线程池,各任务串行执行
     */
    private static void singleThreadExecutorDemo() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(runnableDemo());
        executorService.execute(runnableDemo());
    }

    /**
     * 可延迟调度执行的线程池
     * ScheduledExecutorService可用于周期性调度的任务
     */
    private static void scheduledThreadPoolDemo() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.schedule(runnableDemo(), 3, TimeUnit.SECONDS);
        //10秒后开始执行，以后每小时调度一次
        executorService.scheduleAtFixedRate(runnableDemo(),10, 60*60, TimeUnit.SECONDS);
        System.out.println("submit task success,wait 3s to execute...");
    }

    /**
     * 测试某个runnable抛出异常
     */
    private static void exceptionThreadExecutorDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task " + index + " begin run");
                    if (index == 1) {
                        throw new RuntimeException("ssss");
                    }
                    System.out.println("task " + index + " run completed");
                }
            });
        }
        System.out.println("all tasks had been submitted");
    }

    /**
     * 测试线程池中执行runnable时，前面的runnable一直阻塞，后面的能否得到执行
     */
    private static void blockRunnableDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            final int n = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("enter task "+n);
                    if (n != 3) {
                        try {
                            Thread.sleep(1000000000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        // cachedThreadPoolDemo();
        // cachedThreadPoolWithThreadFactoryDemo();
        // fixedThreadPoolDemo();
        // singleThreadExecutorDemo();
        // scheduledThreadPoolDemo();
        //exceptionThreadExecutorDemo();
        //blockRunnableDemo();
    }

}