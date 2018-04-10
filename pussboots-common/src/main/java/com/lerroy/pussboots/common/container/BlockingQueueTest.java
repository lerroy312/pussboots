/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chunhong.pch on 17/7/30.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {

        BlockingQueue<Long> queue = new LinkedBlockingQueue<Long>(2);
        Random random = new Random(System.currentTimeMillis());
        try {
            queue.put(1L);
            queue.put(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread thread1 = new Thread(new Runnable() {
        //     @Override public void run() {
        //         long n = 0;
        //         while (true){
        //             queue.add(n);
        //             try {
        //                 Thread.sleep(random.nextInt(30));
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //             n+=random.nextInt(100);
        //         }
        //     }
        // });
        //
        // Thread thread2 = new Thread(new Runnable() {
        //     @Override public void run() {
        //         while (true){
        //             long prev = 0;
        //             try {
        //                 long current = queue.take();
        //                 System.out.println(current);
        //                 if(current<prev){
        //                     System.out.println("---------"+current);
        //                 }
        //                 prev = current;
        //                 Thread.sleep(random.nextInt(50));
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // });
        //
        // thread1.start();
        // //thread2.start();
    }
}