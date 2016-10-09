/**
 * 
 */
package com.tracy.string;

/**
 * @author tracy.lu
 * @date:2016年2月29日 下午8:52:06
 * @version :
 */
public class TestString {

    public static void main(String[] args) {
        String a = "hello2";
        String b = "hello";
        String c = b + "2";
        System.out.println(a.hashCode() + " " + c.hashCode());
        System.out.println(a == c);
    }
}
