/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

/**
 * @author tracy.lu
 * @date:2016年3月10日 下午6:53:16
 * @version :两个线程交替运行
 */
public class ThreadSyncronized {

    private void init() {

        final My my = new My();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    my.main(i);
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    my.sub(i);
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        new ThreadSyncronized().init();
    }

    class My {

        private boolean isOk = true;

        public synchronized void main(int i) {
            if (isOk) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("main thread run " + j + ", and loop is " + i);
            }
            isOk = true;
            this.notify();
        }

        public synchronized void sub(int i) {
            if (!isOk) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("sub thread run " + j + ", and loop is " + i);
            }
            isOk = false;
            this.notify();
        }
    }
}
