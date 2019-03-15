/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.concurrent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Created by chunhong.pch on 18/3/26.
 */
public class ParallelStreamDemo {
    private static String s;

    public static void main(String[] args) {
        List<String> fileNames1 = new ArrayList<String>();
        List<String> fileNames2 = new ArrayList<String>();
        for (int i = 0; i < 500; i++) {
            fileNames1.add("/Users/lerroy/Downloads/test/ParallelStream/" + String.valueOf(i));
            fileNames2.add("/Users/lerroy/Downloads/test/executor/" + String.valueOf(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(fileNames1);
        }
        s = stringBuilder.toString();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long executorBegin = System.currentTimeMillis();
        for (String fileName : fileNames2) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    writeFile(fileName);
                }
            });
        }
        long executorEnd = System.currentTimeMillis();
        System.out.println("executor:" + (executorEnd - executorBegin) + "ms");

        long parallelStreamBegin = System.currentTimeMillis();
        fileNames1.parallelStream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                writeFile(s);
            }
        });

        long parallelStreamEnd = System.currentTimeMillis();
        System.out.println("parallelStream:" + (parallelStreamEnd - parallelStreamBegin) + "ms");



    }

    private static void writeFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(s);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}