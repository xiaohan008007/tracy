/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author tracy.lu
 * @date:2016年3月10日 下午5:38:30
 * @version :
 */
public class TimerTest {

    public static void main(String[] args) {
        new Timer().schedule(new myTimerTask(), 100, 100);
    }
}

class myTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("haha");
        new Timer().schedule(new myTimerTask(), 10000);
    }

}
