/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author tracy.lu
 * @date:2016年3月18日 下午3:58:19
 * @version :创建10个线程任然让他们按序一秒一秒执行
 */
public class Test2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        String c = new String("1");
        String d = new String("1");
        String a2 = "2" + c + "3";
        String a3 = "21";
        String a4 = "213";
        String a5 = a + "1";
        String a6 = "11";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(a == a2);
        System.out.println(a2 == a4);
        System.out.println(a5 == a6);
        if (1 == 1) return;
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        final Semaphore s = new Semaphore(1);// 用信号量来解决
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        s.acquire();
                        String log = queue.take();
                        String logAfter = getLog(log);
                        System.out.println(Thread.currentThread().getName() + " " + logAfter + " "
                                           + (System.currentTimeMillis() / 1000));
                        s.release();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {// 此行不可改动
            String log = "" + i;
            try {
                // try {
                // Thread.sleep(1000);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
                queue.put(log);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // String logAfter = getLog("" + i);
            // System.out.println(Thread.currentThread().getName() + " " + logAfter + " "
            // + (System.currentTimeMillis() / 1000));
        }

    }

    private static String getLog(String log) {// 此方法不可改动
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return log;
    }
}
