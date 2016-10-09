/**
 * 
 */
package com.tracy.thread.test_20160229;

/**
 * @author tracy.lu
 * @date:2016年2月29日 下午3:54:50
 * @version :
 */
public class TestThread {

    private int    time;
    private String name;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static class Mythread extends Thread {

        public void run() {

        }
    }
}
