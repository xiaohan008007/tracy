/**
 * 
 */
package com.tracy.thread.test_20160311;

import java.util.Random;

/**
 * @author tracy.lu
 * @date:2016年3月14日 下午5:32:38
 * @version :探讨每个线程间内存相互独立,互不影响
 */
public class ThreadLocalTest {

    // static int data = 0;
    static ThreadLocal<Integer>  x            = new ThreadLocal<Integer>();
    static ThreadLocal<MyObject> threadObject = new ThreadLocal<MyObject>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int data = new Random().nextInt();
                    x.set(data);
                    // MyObject o = new MyObject();
                    // o.setAge(data);
                    // o.setName("name:" + data);
                    // threadObject.set(o);

                    MyObject.getInstance().setAge(data);
                    MyObject.getInstance().setName("name:" + data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

    static class A {

        public void get() {
            System.out.println("A " + Thread.currentThread().getName() + ":" + x.get());
            // System.out.println("A " + Thread.currentThread().getName() + ":" + threadObject.get());
            System.out.println("A " + Thread.currentThread().getName() + ":" + MyObject.getInstance());
        }
    }

    static class B {

        public void get() {
            System.out.println("B " + Thread.currentThread().getName() + ":" + x.get());
            // System.out.println("B " + Thread.currentThread().getName() + ":" + threadObject.get());
            System.out.println("B " + Thread.currentThread().getName() + ":" + MyObject.getInstance());

        }
    }
}

// 先写个单例
class MyObject {

    private String                       name;
    private int                          age;

    private static MyObject              mo = null;
    private static ThreadLocal<MyObject> o  = new ThreadLocal<MyObject>();

    public static/* synchronized */MyObject getInstance() {
        mo = o.get();
        if (mo == null) {
            mo = new MyObject();
            o.set(mo);
        }
        return mo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("MyObject [name=%s, age=%s]", name, age);
    }

}
