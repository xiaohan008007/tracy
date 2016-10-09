package com.tracy.classloader.testHotLoad_20160927;

import com.tracy.classloader.testHotLoad_20160927.entity.BaseManager;

public class MsgHandler implements Runnable {

    @Override
    public void run() {

        while (true) {
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();

        // File loadFile = new File("D:/"+ManagerFactory.MY_MANAGER.replaceAll(".","/")+".class");
        // long lastModified = loadFile.lastModified();
        // System.out.println("com.load.manager.MyManager".replaceAll("\\.","/"));
    }

}
