/**
 * 
 */
package thread.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tracy.lu
 * @date:2015年10月28日 上午11:44:41
 * @version :
 */
public class CounterPoolExecutor extends ThreadPoolExecutor {

    private AtomicInteger   count      = new AtomicInteger(0); // 统计执行次数
    public static final int TASK_COUNT = 4000;
    public long             startTime  = 0;
    public String           funcname   = "";

    /**
     * @param corePoolSize
     * @param maximumPoolSize
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     */
    public CounterPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                               BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected void afterExecute(Runnable r, Throwable t) {
        int l = count.addAndGet(1);// 每次执行完成一个任务就+1
        if (l == TASK_COUNT) {
            System.out.println(funcname + " spend time:" + (System.currentTimeMillis() - startTime));
        }
    }
}
