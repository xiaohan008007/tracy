/**
 * 
 */
package com.tracy.thread.test_20160311;

/**
 * @author tracy.lu
 * @date:2016年3月14日 下午6:19:34
 * @version :
 */
public class MultiThreadShareData {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final ShareData data = new ShareData();
        for (int i = 0; i < 20; i++) {
            new Thread(new ShareData1(data)).start();
            new Thread(new ShareData2(data)).start();
            // new Thread(new Runnable() {
            //
            // @Override
            // public void run() {
            // data.increment();
            // }
            // }).start();
            // new Thread(new Runnable() {
            //
            // @Override
            // public void run() {
            // data.decrement();
            //
            // }
            // }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(data.getCount());
    }
}

class ShareData1 implements Runnable {

    ShareData data = null;

    public ShareData1(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.increment();
    }

}

class ShareData2 implements Runnable {

    ShareData data = null;

    public ShareData2(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.decrement();
    }

}

class ShareData {

    private int count = 10;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
