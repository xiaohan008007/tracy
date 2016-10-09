package com.tracy.thread.test_20160226;

public class TestSynchronized implements Runnable {

    private Integer ticket = 2000;

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始卖票！");
        while (ticket > 0) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ticket) {// 采用同步机制
                System.out.print(Thread.currentThread().getName() + "(" + System.currentTimeMillis() + ")：卖掉 "
                                 + ticket-- + " 号票 ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        TestSynchronized test = new TestSynchronized();
        for (int i = 0; i < 100; i++) {
            new Thread(test, (i + 1) + "号窗口").start();
        }
        // Thread t2 = new Thread(test, "2号窗口");
        // Thread t3 = new Thread(test, "3号窗口");
        // t2.start();
        // t3.start();
        // 1456735840947
        // 1456735842962
        // 1456735985002
        // 1456735987011

        // 1456736057989
        // 1456736258004
        // 1456736321913
        // 1456736521925
    }
}
