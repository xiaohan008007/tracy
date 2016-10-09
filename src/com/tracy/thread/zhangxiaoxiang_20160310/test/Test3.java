/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310.test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tracy.lu
 * @date:2016年3月18日 下午4:54:16
 * @version :让同一key值得间隔1秒打印，不同的同时打印---ps没改前的代码就是不管3721所有都同时打印
 */
public class Test3 extends Thread {

    private TestDo testDo;
    private String key;
    private String value;

    public Test3(String key, String value) {
        testDo = TestDo.getInstance();
        this.key = key + "";// 这里用1+""这种方式保证 a和b的key 不是同一个对象，这样就无法单纯使用syncronized来解决
        this.value = value;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // List<String> list = new ArrayList<String>();
        // String a = "haha";
        // String b = "";
        // String c = a + b;
        // System.out.println(a == c);
        // list.add(a);
        // if (list.contains(c)) {
        // System.out.println(c);
        // }
        Test3 a = new Test3("1", "1");
        Test3 b = new Test3("1", "1");
        Test3 c = new Test3("2", "2");
        Test3 d = new Test3("3", "3");
        a.start();
        b.start();
        c.start();
        d.start();
        for (int i = 0; i < 10; i++) {
            new Test3("1", "1").start();
        }
    }

    public void run() {
        testDo.doSome(key, value);
    }

}

class TestDo {

    private static TestDo                testDo     = new TestDo();

    // private List<Object> objectList = new ArrayList<Object>(); // 此list在迭代的同时往list中加数据会报 Exception in thread

    // "Thread-0"
    // java.util.ConcurrentModificationException at
    // java.util.ArrayList$Itr.checkForComodification(Unknown
    // Source)
    private CopyOnWriteArrayList<Object> objectList = new CopyOnWriteArrayList<Object>();

    public static TestDo getInstance() {
        return testDo;
    }

    public void doSome(Object key, String value) {
        if (!objectList.contains(key)) {
            objectList.add(key);
            System.out.println(key);
        }
        for (Object o : objectList) {
            if (o.equals(key)) {
                key = o;
                break;
            }
        }
        // if (objectList.contains(key)) {
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // } else {
        // objectList.add(key);
        // }
        // } else {
        // duplicateSet.add(key);
        // }
        synchronized (key) {
            {// 此大括号内代码不能改动
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " key=" + key + " "
                                       + (System.currentTimeMillis() / 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
