package com.tracy.reflect;

import java.lang.reflect.Method;

public class TestReflect {

    // public static void main(String[] args) {
    // Class<?> demo = null;
    // try {
    // demo = Class.forName("com.tracy.reflect.ReflectPointer");
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // try {
    // // 调用Person类中的sayChina方法
    // Method method = demo.getMethod("getX");
    // method.invoke(demo.newInstance());
    // // // 调用Person的sayHello方法
    // // method = demo.getMethod("sayHello", String.class, int.class);
    // // method.invoke(demo.newInstance(), "Rollen", 20);
    //
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException,
                                          IllegalArgumentException, Exception {
        // ReflectPointer rp1 = new ReflectPointer(3, 4);
        Class c = Class.forName("com.tracy.reflect.ReflectPointer");
        Method m1 = c.getMethod("setX", int.class);
        m1.invoke(c.newInstance(), 1);
        Method m = c.getMethod("getX");
        System.out.println(m.invoke(c.newInstance()));
        // Field fieldx = c.getField("x");// 必须是x或者y
        // // fieldx.set(c, 8);
        // System.out.println(fieldx.get(c.newInstance()));

        /*
         * private的成员变量必须使用getDeclaredField，并setAccessible(true),否则看得到拿不到
         */
        // Field fieldy = rp1.getClass().getDeclaredField("y");
        // fieldy.setAccessible(true);// 暴力反射
        // System.out.println(fieldy.get(rp1));

    }

}
