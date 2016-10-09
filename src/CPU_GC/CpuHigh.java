/**
 * 
 */
package CPU_GC;

import java.util.ArrayList;

/**
 * @author tracy.lu
 * @date:2014-3-27 上午10:47:44
 * @version :
 */
public class CpuHigh {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CpuHigh c = new CpuHigh();
        c.runTest();

    }

    private void runTest() throws Exception {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            new Thread(new ConsumeCPUTask()).start();
        }
        for (int i = 0; i < 200; i++) {
            new Thread(new NotConsumeCPUTask()).start();
        }
    }

    class ConsumeCPUTask implements Runnable {

        public void run() {
            String str = "slkjfsoiufsdlkgfdsljfsldfjdlskfjdsfuwehlkfhwlekr23oi43028974wfjwo7u32042ojirslkjfdsfsdfsdlkj"
                         + "oidufdslkjf#sdlkfhoiweuroi3240798324809237oijhsdof893745893242" + "324890hodsfoiesrew";
            float i = 0.002f;
            float j = 232.13243f;
            while (true) {
                j = i * j;
                str.indexOf("#");
                ArrayList<String> list = new ArrayList<String>();
                for (int k = 0; k < 10000; k++) {
                    list.add(str + String.valueOf(k));
                }
                list.contains("iii");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class NotConsumeCPUTask implements Runnable {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
