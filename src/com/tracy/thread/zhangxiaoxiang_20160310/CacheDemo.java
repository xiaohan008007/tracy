package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 利用读写锁写一个缓存系统
 * 
 * @author 谭飞
 * @date 2012-02-03
 */
public class CacheDemo {

    private Map<String, Object> cache = new HashMap<String, Object>(); // 用于存放缓存的数据集

    /**
     * @param args
     */
    public static void main(String[] args) {
        final CacheDemo demo = new CacheDemo();
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        final String key = "mykey";
        for (int i = 0; i < 1000; i++) {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    demo.getCache2(key);
                }
            });
        }
        // demo.cache.put("3", 123456);
        // System.out.println("返回的值：" + demo.getCache2("3"));
        pool.shutdown();
    }

    /*
     * 利用synchronized同步，但是有缺陷，当是很多线程读取数据时不应该用， 因为这样会降低效率，最好用读写锁来控制
     */
    public synchronized Object getCache1(String key) {
        Object value = null;
        value = cache.get(key);
        if (value == null) {
            // 查询数据操作 此处省略
            value = "数据库取得的值";
        }
        return value;
    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock(); // 创建读写锁

    /* 利用读写锁来控制多个线程的读写操作 */
    public Object getCache2(String key) {
        rwl.readLock().lock();// 打开读锁
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();// 关闭读锁
                rwl.writeLock().lock();// 打开写锁
                try {
                    if (value == null)// 再次检测该值是否为null，因为在多个线程访问的时候，写数据的时候会把其它写的线程堵在外面，一旦写完后，这个value存在值了就不用再去查询数据库了，以此来提高系统的效率
                    {
                        // 查询数据操作 此处省略
                        value = "数据库取得的值";
                        System.out.println("=============put");
                        cache.put(key, value);
                    }
                } finally {
                    rwl.writeLock().unlock();// 关闭写锁
                }
                rwl.readLock().lock();// 打开读锁
            }
        } finally {
            rwl.readLock().unlock();// 关闭读锁
        }
        return value;
    }

}
