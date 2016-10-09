/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tracy.lu
 * @date:2016年3月17日 下午5:05:16
 * @version :
 */
public class ExchangerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Exchanger<String> ex = new Exchanger<String>();
        pool.execute(new Runnable() {

            @Override
            public void run() {
                String data1 = "apple";
                System.out.println(Thread.currentThread().getName() + "准备把" + data1 + "交换出去");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    String data2 = ex.exchange(data1);
                    System.out.println(Thread.currentThread().getName() + "换到了" + data2 + "");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {

            @Override
            public void run() {
                String data1 = "banner";
                System.out.println(Thread.currentThread().getName() + "准备把" + data1 + "交换出去");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    String data2 = ex.exchange(data1);
                    System.out.println(Thread.currentThread().getName() + "换到了" + data2 + "");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {

            @Override
            public void run() {
                String data1 = "pi";
                System.out.println(Thread.currentThread().getName() + "准备把" + data1 + "交换出去");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    String data2 = ex.exchange(data1);
                    System.out.println(Thread.currentThread().getName() + "换到了" + data2 + "");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {

            @Override
            public void run() {
                String data1 = "0";
                System.out.println(Thread.currentThread().getName() + "准备把" + data1 + "交换出去");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    String data2 = ex.exchange(data1);
                    System.out.println(Thread.currentThread().getName() + "换到了" + data2 + "");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        pool.shutdown();

    }
}
