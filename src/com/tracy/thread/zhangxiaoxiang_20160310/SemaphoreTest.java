/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author tracy.lu
 * @date:2016年3月16日 下午7:12:07
 * @version :
 */
public class SemaphoreTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore s = new Semaphore(3, true);
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("当前已有" + (3 - s.availablePermits()) + "个并发");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "即将离开");
                    s.release();
                    System.out.println(Thread.currentThread().getName() + "已离开,剩余" + (3 - s.availablePermits()) + "个并发");
                }
            });
        }

    }

}
