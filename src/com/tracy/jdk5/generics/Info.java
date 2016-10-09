package com.tracy.jdk5.generics;

class Info<T extends Number> { // 指定上限，只能是数字类型

    private T var; // 此类型由外部决定

    public T getVar() {
        return this.var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    public String toString() { // 覆写Object类中的toString()方法
        return this.var.toString();
    }
};
