/**
 * 
 */
package com.tracy.jdk5.generics;

/**
 * @author tracy.lu
 * @date:2015年11月19日 上午11:05:19
 * @version :
 */
public class TestDemo {

    // class Demo1 {
    //
    // public <T> T fun(T t) { // 可以接收任意类型的数据
    // return t; // 直接把参数返回
    // }
    // };

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Point<String> point = new Point<String>();
        // point.setVar("test");
        // System.out.println(point.getVar());
        //
        // Point<Integer> point2 = new Point<Integer>();
        // point2.setVar(1);
        // System.out.println(point2.getVar());

        Demo1 demo = new Demo1();
        System.out.println(demo.fun("test"));
        System.out.println(demo.fun(1));
    }
}
