/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tracy.lu
 * @date:2016年3月17日 下午4:40:57
 * @version :
 */
public class CountDownLatchTest {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch endLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "在等待起跑命令");
                    try {
                        startLatch.await();
                        System.out.println(Thread.currentThread().getName() + "接到命令开始跑");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + "到达终点");
                        endLatch.countDown();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "即将发令开跑");
        startLatch.countDown();
        System.out.println(Thread.currentThread().getName() + "已发令开跑，等待成绩");
        endLatch.await();
        System.out.println(Thread.currentThread().getName() + "在终点公布成绩");
        pool.shutdown();
    }

}
