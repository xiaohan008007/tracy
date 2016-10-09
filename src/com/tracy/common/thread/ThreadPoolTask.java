package com.tracy.common.thread;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {  
  
    private Object attachData;  
  
    ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
  
    public void run() {  
          
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        System.out.println("开始执行任务：" + attachData);  
        attachData = null;  
    }  
  
    public Object getTask() {  
        return this.attachData;  
    }  
}  