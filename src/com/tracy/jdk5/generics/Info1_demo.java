/**
 * 
 */
package com.tracy.jdk5.generics;

/**
 * @author tracy.lu
 * @date:2015年11月19日 上午11:45:17
 * @version :
 */
public class Info1_demo {

    public static void main(String arsg[]) {
        Info1<String> i = null; // 声明接口对象
        i = new Info1Impl<String>("汤姆"); // 通过子类实例化对象
        System.out.println("内容：" + i.getVar());
    }
}
