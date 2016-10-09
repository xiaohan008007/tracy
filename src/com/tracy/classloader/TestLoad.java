package com.tracy.classloader;

public class TestLoad {

    public void sayHello(String word) {

        System.out.println("hehe101 is " + TestLoad.class.getClassLoader().getClass().getName());
    }
}
