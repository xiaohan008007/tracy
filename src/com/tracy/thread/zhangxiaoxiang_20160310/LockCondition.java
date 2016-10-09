/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tracy.lu
 * @date:2016年3月16日 下午4:13:53
 * @version :老大(线程)执行10次 老二(线程)执行5次 老三(线程)再执行8次 以此顺序轮10次
 */
public class LockCondition {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        final A a = new A();
        pool.execute(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    a.sub1(i);
                }
            }
        });
        pool.execute(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    a.sub2(i);
                }
            }
        });
        pool.execute(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    a.sub3(i);
                }
            }
        });
        pool.shutdown();
    }

    static class A {

        Lock      lock       = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        int       seq        = 1;

        public void sub1(int k) {
            lock.lock();
            try {
                while (seq != 1)
                    condition1.await();
                for (int i = 1; i <= 10; i++) {
                    System.out.println("1sub run " + i + ", the loop is " + k);
                }
                seq = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void sub2(int k) {
            lock.lock();
            try {
                while (seq != 2)
                    condition2.await();
                for (int i = 1; i <= 5; i++) {
                    System.out.println("2sub run " + i + ", the loop is " + k);
                }
                seq = 3;
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void sub3(int k) {
            lock.lock();
            try {
                while (seq != 3)
                    condition3.await();
                for (int i = 1; i <= 8; i++) {
                    System.out.println("3sub run " + i + ", the loop is " + k);
                }
                seq = 1;
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
