/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by chunhong.pch on 17/8/13.
 */
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int index = i;
            futureList.add(executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    if (index == 1) {
                        throw new Exception("index:" + index + " call exception");
                    }
                    return "sssss";
                }
            }));
        }

        for (Future<String> future : futureList) {
            try {
                String resultMsg = future.get();
                System.out.println(resultMsg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}