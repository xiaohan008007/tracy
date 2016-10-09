/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tracy.lu
 * @date:2016年3月16日 下午4:36:35
 * @version :
 */
public class LockConditionBlockQueue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final BlockQueue queue = new BlockQueue();
        for (int i = 0; i < 50; i++) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(queue.get());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }).start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        queue.put(new Random().nextInt(100));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }

    static class BlockQueue {

        int       count        = 0;
        int       putindex     = 0;
        int       getindex     = 0;
        Object[]  queue        = new Object[10];
        Lock      lock         = new ReentrantLock();
        Condition putCondition = lock.newCondition();
        Condition getCondition = lock.newCondition();

        public void put(Object x) throws InterruptedException {
            lock.lock();
            try {
                if (count == queue.length) putCondition.await();
                count++;
                queue[putindex] = x;
                putindex++;
                if (putindex == queue.length) putindex = 0;// 指针到头了，如果那另一边一直在读取的话，那前头已经读过了，从头再来
                getCondition.signal();// 通知可以读了

            } finally {
                lock.unlock();
            }
        }

        public Object get() throws InterruptedException {
            lock.lock();
            try {
                if (count == 0) getCondition.await();
                count--;
                Object x = queue[getindex];
                getindex++;
                if (getindex == queue.length) getindex = 0;// 游标到头了，从头再取
                putCondition.signal();
                return x;

            } finally {
                lock.unlock();
            }
        }

    }
}
