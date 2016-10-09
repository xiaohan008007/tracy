/**
 * 
 */
package thread.concurrent;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Maps;

/**
 * @author tracy.lu
 * @date:2015年10月28日 上午11:35:35
 * @version :
 */
public class AccessMapThread implements Runnable {

    protected String              name;
    private Random                rand = new Random();
    private Map<Integer, Integer> map  = Maps.newHashMap();

    // private Map<Integer, Integer> map = Maps.newConcurrentMap();

    public AccessMapThread() {

    }

    public AccessMapThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500; i++) {
                handleMap(rand.nextInt(1000));

            }
            Thread.sleep(rand.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object handleMap(int index) {
        map.put(rand.nextInt(2000), 100);
        return map.get(index);
    }

    public static void main(String[] args) {
        CounterPoolExecutor exe = new CounterPoolExecutor(2000, 2000, 0l, TimeUnit.MILLISECONDS,
                                                          new LinkedBlockingQueue<Runnable>());
        long startTime = System.currentTimeMillis();
        exe.startTime = startTime;
        exe.funcname = "testConcurrentHashMap";
        for (int i = 0; i < 4000; i++) {
            exe.submit(new AccessMapThread());
        }
    }
}
