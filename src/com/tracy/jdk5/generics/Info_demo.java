package com.tracy.jdk5.generics;

public class Info_demo {

    public static void main(String args[]) {
        Info<Integer> i = fun(30);
        System.out.println(i.getVar());
    }

    public static <T extends Number> Info<T> fun(T param) {// 方法中传入或返回的泛型类型由调用方法时所设置的参数类型决定
        Info<T> temp = new Info<T>(); // 根据传入的数据类型实例化Info
        temp.setVar(param); // 将传递的内容设置到Info对象的var属性之中
        return temp; // 返回实例化对象
    }
};
