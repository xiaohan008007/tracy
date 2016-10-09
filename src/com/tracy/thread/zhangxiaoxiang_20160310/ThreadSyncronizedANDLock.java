/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tracy.lu
 * @date:2016年3月15日 下午4:28:51
 * @version :
 */
public class ThreadSyncronizedANDLock {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final A a = new A();
        while (true) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    a.out("wo shi shui");

                }
            }).start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    a.out("buqingchu");

                }
            }).start();
        }
    }

    static class A {

        Lock lock = new ReentrantLock();

        public/* synchronized */void out(String name) {
            lock.lock();
            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }

}
