package com.tracy.reflect;

public class ReflectPointer {

    public int  x = 0;
    private int y = 0;

    public ReflectPointer() {
    }

    public ReflectPointer(int x, int y) {// alt + shift +s相当于右键source
        super();
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
