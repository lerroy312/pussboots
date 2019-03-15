package com.lerroy.pussboots.common.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    //java中原子（CAS）操作
    //持有自旋锁的线程对象
    AtomicReference<Thread> owner = new AtomicReference<Thread>();

    /** 引用计数 */
    private int             count;

    /**
     * 加锁
     */
    public void lock() {

        Thread cur = Thread.currentThread();
        if (owner.get() == cur) {
            //本线程已经持有锁，则增加引用计数
            count++;
            return;
        }

        // lock函数将owner设置为当前线程，并且预测原来的值为空
        // 当有第二个线程调用lock操作时由于owner值不为空，导致循环	

        //一直被执行，直至第一个线程调用unlock函数将owner设置为null，第二个线程才能进入临界区。
        while (!owner.compareAndSet(null, cur)) {
            System.out.println(cur.getName() + " block");
        }
    }

    /**
     * 释放锁
     */
    public void unLock() {
        //unlock函数将owner设置为null,并且预测值为当前线程
        Thread cur = Thread.currentThread();
        owner.compareAndSet(cur, null);
    }

    /**
     * 测试代码
     * @param args
     */
    public static void main(String[] args) {
        final SpinLock spinLock = new SpinLock();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("thread1 try to lock 1...");
                spinLock.lock();
                System.out.println("thread1 lock 1 success");

                System.out.println("thread1 try to lock 2...");
                spinLock.lock();
                System.out.println("thread1 lock 2 success");

                System.out.println("thread1 try to unlock 1");
                spinLock.unLock();
                System.out.println("thread1 unlock 1 success");

                System.out.println("thread1 try to unlock 2");
                spinLock.unLock();
                System.out.println("thread1 unlock 2 success");
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("thread2 try to lock 1...");
                spinLock.lock();
                System.out.println("thread2 lock 1 success");

                System.out.println("thread2 try to lock 2...");
                spinLock.lock();
                System.out.println("thread2 lock 2 success");

                System.out.println("thread2 try to unlock 1");
                spinLock.unLock();
                System.out.println("thread2 unlock 1 success");

                System.out.println("thread2 try to unlock 2");
                spinLock.unLock();
                System.out.println("thread2 unlock 2 success");
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
