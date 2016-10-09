/**
 * 
 */
package com.tracy.thread.test_20160311;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tracy.lu
 * @date:2016年3月14日 下午8:01:54
 * @version :
 */
public class ThreadPool {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // ExecutorService pool = Executors.newFixedThreadPool(3);
        // ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int task = i;
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " " + j + " looping of " + task);
                    }

                }
            });
        }

        // pool.shutdown();
        pool.shutdownNow();
    }
}
