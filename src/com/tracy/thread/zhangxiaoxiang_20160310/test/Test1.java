/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310.test;

/**
 * @author tracy.lu
 * @date:2016年3月18日 下午3:28:08
 * @version :
 */
public class Test1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("begin " + (System.currentTimeMillis() / 1000));
        for (int i = 0; i < 16; i++) {
            final String log = "" + i;
            {
                parseLog(log);
            }
        }

    }

    private static void parseLog(String log) {
        System.out.println(log + " " + (System.currentTimeMillis() / 1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
