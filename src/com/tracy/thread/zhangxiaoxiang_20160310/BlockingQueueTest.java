/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tracy.lu
 * @date:2016年3月17日 下午5:43:43
 * @version :用阻塞队列实现 两个线程交替执行
 */
public class BlockingQueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final BlockingQueueDone b = new BlockingQueueDone();
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {

                        b.job1();
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {

                        b.job2();
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        pool.shutdown();

    }

    static class BlockingQueueDone {

        private BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
        private BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
        {
            try {
                queue2.put(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void job1() throws InterruptedException {
            // System.out.println("queue1 准备执行放入");
            queue1.put(1);
            for (int j = 0; j < 10; j++) {
                System.out.println("1job thread run " + j + ", and loop is ");
            }
            // System.out.println("queue1 放入完成");
            // System.out.println("queue2 取走数据");
            queue2.take();
        }

        public void job2() throws InterruptedException {
            // System.out.println("queue2 准备执行放入");
            queue2.put(1);
            for (int j = 0; j < 10; j++) {
                System.out.println("2job thread run " + j + ", and loop is ");
            }
            // System.out.println("queue2 放入完成");
            // System.out.println("queue1 取走数据");
            queue1.take();
        }
    }

}
