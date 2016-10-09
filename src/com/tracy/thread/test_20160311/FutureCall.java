/**
 * 
 */
package com.tracy.thread.test_20160311;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author tracy.lu
 * @date:2016年3月15日 下午3:57:18
 * @version :
 */
public class FutureCall {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<String> future = pool.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "hello";
            }
        });
        System.out.println("等待结果");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("结束结果");

        // 多个同时放入执行 等待最先成熟的先返回
        ExecutorService pool2 = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(pool2);
        for (int i = 0; i < 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }
        System.out.println("等待结果");
        for (int i = 0; i < 10; i++) {

            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("jieshu");
    }
}
