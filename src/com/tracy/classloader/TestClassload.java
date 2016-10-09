/**
 * 
 */
package com.tracy.classloader;

/**
 * @author tracy.lu
 * @date:2016年3月8日 下午4:16:52
 * @version :
 */
public class TestClassload {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new A();
        System.out.println("=================================lala-==============");
        new B();
        new C();

    }

}

class A {

}

class B {

}

class C {

    static {
        System.out.println("=================================iiiiiii-==============");
    }

}
