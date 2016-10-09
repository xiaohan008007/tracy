/**
 * 
 */
package com.tracy.jdk5.generics;

/**
 * @author tracy.lu
 * @date:2015年11月19日 上午11:44:33
 * @version :
 */
public class Info1Impl<T> implements Info1<T> {

    private T var; // 定义属性

    public Info1Impl(T var) { // 通过构造方法设置属性内容
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }
}
