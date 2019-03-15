/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 *
 * @author chunhong.pch
 * @version $Id: ThreadExecutorMonitor.java, v 0.1 2019年03月15日 16:57 chunhong.pch Exp $
 */
public class ThreadExecutorMonitor implements Runnable {
    private static ScheduledExecutorService monitor   = Executors
        .newSingleThreadScheduledExecutor();
    private static List<ThreadPoolExecutor> executors = new ArrayList<>();

    static {
        monitor.scheduleWithFixedDelay(new ThreadExecutorMonitor(), 0, 1, TimeUnit.SECONDS);
    }

    public static ThreadPoolExecutor register(Supplier<ThreadPoolExecutor> supplier) {
        ThreadPoolExecutor executor = supplier.get();
        executors.add(executor);
        return executor;
    }

    public static void register(ThreadPoolExecutor executor) {
        executors.add(executor);
    }

    @Override
    public void run() {
        for (int i = 0; i < executors.size(); i++) {
            ThreadPoolExecutor executor = executors.get(i);
            System.out.println(
                "index:" + i + ", queueSize=" + executor.getQueue().size() + ", activeCount="
                               + executor.getActiveCount() + ",poolSize=" + executor.getPoolSize());
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor1 = ThreadExecutorMonitor.register(() -> {
            return new ThreadPoolExecutor(2, 2, 1, TimeUnit.DAYS, new LinkedBlockingQueue<>(100));
        });

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2, 2, 1, TimeUnit.DAYS,
            new LinkedBlockingQueue<>(100));
        ThreadExecutorMonitor.register(executor2);

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            executor1.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(random.nextInt(1000));
                        System.out.println("executor1 completed");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            executor2.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(random.nextInt(1000));
                        System.out.println("executor2 completed");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("executor add");
        }

    }
}