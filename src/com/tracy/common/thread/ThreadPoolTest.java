package com.tracy.common.thread;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 线程池例子
 * 
 * @author gang.dug   qq:53732908 
 */
public class ThreadPoolTest {

    private static final long   TASK_SLEEP_TIME  = 3000;
    private static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    private static DateFormat   dateFormat       = new SimpleDateFormat(FULL_DATE_FORMAT);

    public static void main(String[] args) throws Exception {
        // 线程池 数据库连接池 可联系起来
        int corePoolSize = 3;// minPoolSize
        int maxPoolSize = 5;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        int maxTaskSize = 5;// 任务队列最大容量
        // 任务队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(maxTaskSize);
        // 饱和处理策略
        RejectedExecutionHandler handler = new AbortPolicy();
        ThreadPoolExecutor pool = null;
        // 创建线程池
        pool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue, new CollectorRejectedExecutionHandler());
        // 生产者消费者队列 阻塞队列
        // 任务先提交到任务队列
        // 线程池中线程 从任务队列里获取任务并执行
        // 任务需要实现Runnable接口

        // corePoolSize //核心池的大小 minPoolSize
        // maxPoolSize //最大池的大小
        // keepAliveTime //超出corePoolSize时 线程最大空闲时间
        // workQueue //任务队列
        // handler //饱和策略
        // 何时执行饱和策略 线程个数==maxPoolSize && 任务队列已满

        // 各种饱和策略
        // AbortPolicy 抛异常RejectedExecutionException
        // CallerRunsPolicy 调度者执行
        // DiscardOldestPolicy放弃最旧的未处理请求，执行新传入的任务
        // DiscardPolicy 不做任何操作，放弃新任务

        System.out.println(getPoolInfo(pool));
        // poolSize=0,activeCount=0,completedTaskCount=0,taskCount=0,taskWaitCount=0
        Runnable r = null;

        r = new MyTask("thread0");
        pool.execute(r);
        Thread.sleep(100);
        System.out.println(getPoolInfo(pool));
        // poolSize=1,activeCount=1,completedTaskCount=0,taskCount=1,taskWaitCount=0
        Thread.sleep(TASK_SLEEP_TIME + 200);
        System.out.println(getPoolInfo(pool));
        // 第一个任务执行完成 activeCount=0,completedTaskCount=1
        // poolSize=1,activeCount=0,completedTaskCount=1,taskCount=1,taskWaitCount=0
        // 任务执行 抛出异常的情况
        r = new MyTask("errorThread", true);
        pool.execute(r);
        Thread.sleep(100);
        System.out.println(getPoolInfo(pool));
        // 抛出异常的任务不统计
        // poolSize=1,activeCount=0,completedTaskCount=1,taskCount=1
        // 任务执行异常在线程池内部抛出 外部不需要catch
        for (int i = 1; i < 20; i++) {
            try {
                Thread.sleep(100);
                r = new MyTask("thread" + i);
                pool.execute(r);
                System.out.println(getPoolInfo(pool));
            } catch (Throwable e) {
                System.out.println(e + "," + r);
            }
        }
        // poolSize=3,activeCount=3,completedTaskCount=1,taskCount=5,taskWaitCount=1
        // poolSize=3,activeCount=3,completedTaskCount=1,taskCount=6,taskWaitCount=2
        // poolSize=3,activeCount=3,completedTaskCount=1,taskCount=7,taskWaitCount=3
        // poolSize=3,activeCount=3,completedTaskCount=1,taskCount=8,taskWaitCount=4
        // poolSize=3,activeCount=3,completedTaskCount=1,taskCount=9,taskWaitCount=5
        // poolSize=4,activeCount=3,completedTaskCount=1,taskCount=9,taskWaitCount=5

        // 任务队列大小 taskWaitCount = taskCount-completedTaskCount-activeCount
        // 任务队列满时才会 增加线程

        Thread.sleep(20000);
        // 线程空闲超过 keepAliveTime 会被清理掉
        // 直到线程数量为 corePoolSize/minPoolSize
        System.out.println(getPoolInfo(pool));
        // poolSize=3,activeCount=0,completedTaskCount=11,taskCount=11,taskWaitCount=0
        // 关闭线程池 已提交的任务执行完毕后再关闭
        pool.shutdown();
    }

    private static class MyTask implements Runnable {

        private boolean throwException = false;
        private String  name           = null;

        public MyTask(String name) {
            this.name = name;
        }

        public MyTask(String name, boolean throwException) {
            this.name = name;
            this.throwException = throwException;
        }

        public void run() {
            if (throwException) {
                throw new RuntimeException("run error,name=" + name);
            }
            System.out.println("MyThread " + name + " start " + now());
            sleep(TASK_SLEEP_TIME);
            // System.out.println("MyThread " + name + " run end " + now());
        }
    }

    private static String getPoolInfo(ThreadPoolExecutor pool) {
        String s = "";
        // 线程池大小 当前工作线程数量
        int poolSize = pool.getPoolSize();
        // 正在运行的任务
        int activeCount = pool.getActiveCount();
        // 运行结束的任务
        long completedTaskCount = pool.getCompletedTaskCount();
        // 任务总数
        long taskCount = pool.getTaskCount();
        // 等待运行的 任务队列里的任务数量
        long taskWaitCount = taskCount - completedTaskCount - activeCount;
        s = s + "poolSize=" + poolSize;
        s = s + ",activeCount=" + activeCount;
        s = s + ",completedTaskCount=" + completedTaskCount;
        s = s + ",taskCount=" + taskCount;
        s = s + ",taskWaitCount=" + taskWaitCount;
        return s;
    }

    private static void sleep(long sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String now() {
        return dateFormat.format(new Date());
    }
}
