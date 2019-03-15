package com.lerroy.pussboots.common.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    //java��ԭ�ӣ�CAS������
    //�������������̶߳���
    AtomicReference<Thread> owner = new AtomicReference<Thread>();

    /** ���ü��� */
    private int             count;

    /**
     * ����
     */
    public void lock() {

        Thread cur = Thread.currentThread();
        if (owner.get() == cur) {
            //���߳��Ѿ������������������ü���
            count++;
            return;
        }

        // lock������owner����Ϊ��ǰ�̣߳�����Ԥ��ԭ����ֵΪ��
        // ���еڶ����̵߳���lock����ʱ����ownerֵ��Ϊ�գ�����ѭ��	

        //һֱ��ִ�У�ֱ����һ���̵߳���unlock������owner����Ϊnull���ڶ����̲߳��ܽ����ٽ�����
        while (!owner.compareAndSet(null, cur)) {
            System.out.println(cur.getName() + " block");
        }
    }

    /**
     * �ͷ���
     */
    public void unLock() {
        //unlock������owner����Ϊnull,����Ԥ��ֵΪ��ǰ�߳�
        Thread cur = Thread.currentThread();
        owner.compareAndSet(cur, null);
    }

    /**
     * ���Դ���
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
