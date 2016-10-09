/**
 * 
 */
package com.tracy.classloader;

/**
 * @author tracy.lu
 * @date:2016年3月8日 下午4:42:23
 * @version :
 */
public class TestJdkClassloader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(TestJdkClassloader.class.getClassLoader().getClass().getClassLoader());

    }

}
