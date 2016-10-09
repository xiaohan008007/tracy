/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tracy.lu
 * @date:2016年3月15日 下午5:16:00
 * @version :
 */
public class CacheLockTest {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final CacheLock cache = new CacheLock();
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        final String key = "mykey";
        for (int i = 0; i < 1000; i++) {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        cache.getCache(key);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

        System.out.println("读缓存啦");
        // Thread.sleep(2000);
        // System.out.println(cache.getCache(key));
        pool.shutdown();
    }
}

class CacheLock {

    private Map<String, Object> cache = new HashMap<String, Object>();
    private ReadWriteLock       rwl   = new ReentrantReadWriteLock();

    public Object getCache(String key) throws InterruptedException {
        rwl.readLock().lock();
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();// 发现缓存中无数据,则开始写缓存,此时可以释放读锁
                rwl.writeLock().lock();// 准备开始写数据，加写锁

                if (value == null) {// 此处再次判断，防止并发进入等待写锁释放的线程（60行）在写锁释放（69行）后重复写入
                    Thread.sleep(1000);
                    value = "===赋值数据===";// 此过程替代从数据库读取
                    System.out.println(Thread.currentThread().getName() + " +++++++++put");
                    cache.put(key, value);
                }

                rwl.writeLock().unlock();// 写入完毕，释放写锁
                rwl.readLock().lock();// 数据已有，再次加读锁,形成闭环
            }
        } finally {
            rwl.readLock().unlock();// 读完毕，释放读锁
        }
        if (value == null) System.out.println(Thread.currentThread().getName() + " ===get===" + value);
        return value;
    }
}
