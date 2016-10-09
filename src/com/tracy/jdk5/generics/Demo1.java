package com.tracy.jdk5.generics;

class Demo1 {

    public <T> T fun(T t) { // 可以接收任意类型的数据
        return t; // 直接把参数返回
    }
};
