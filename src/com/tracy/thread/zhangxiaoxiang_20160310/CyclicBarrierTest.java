/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tracy.lu
 * @date:2016年3月17日 下午4:17:33
 * @version :
 */
public class CyclicBarrierTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(10000));
                        System.out.println(Thread.currentThread().getName() + "到达集合点,当前有" + (cb.getNumberWaiting() + 1)
                                           + "个人在等待," + ((cb.getNumberWaiting() + 1) == 3 ? "人到齐了，走吧" : "人没到齐继续等待"));
                        cb.await();
                        System.out.println("go");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
