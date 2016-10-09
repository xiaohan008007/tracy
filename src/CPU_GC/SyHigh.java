/**
 * 
 */
package CPU_GC;

import java.util.Random;

/**
 * @author tracy.lu
 * @date:2014-3-28 上午10:41:50
 * @version : 上下文切换较高 系统cpu使用较高
 */
public class SyHigh {

    private static int threadCount = 500;

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        SyHigh demo = new SyHigh();
        demo.runTest();
    }

    private Random   random = new Random();

    private Object[] locks;

    private void runTest() throws Exception {
        // int cpuCount = Runtime.getRuntime().availableProcessors() * 150;
        locks = new Object[threadCount];
        for (int i = 0; i < threadCount; i++) {
            locks[i] = new Object();
        }
        for (int i = 0; i < threadCount; i++) {
            new Thread(new ATask(i)).start();
        }
        for (int i = 0; i < threadCount; i++) {
            new Thread(new BTask(i)).start();
        }
    }

    class ATask implements Runnable {

        private Object lockObject = null;

        public ATask(int i) {
            lockObject = locks[i];
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lockObject) {
                        lockObject.wait(random.nextInt(10));
                    }
                } catch (Exception e) {
                    ;
                }
            }
        }
    }

    class BTask implements Runnable {

        private Object lockObject = null;

        public BTask(int i) {
            lockObject = locks[i];
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lockObject) {
                    lockObject.notifyAll();
                }
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
