/**
 * 
 */
package com.tracy.classloader;

import java.lang.reflect.Method;

/**
 * @author tracy.lu
 * @date:2016年3月28日 下午2:46:33
 * @version :
 */
public class TestMyClassloader {

    /**
     * @param args
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        ClassLoader loader1 = TestMyClassloader.class.getClassLoader();
        while (loader1 != null) {
            System.out.println(loader1.getClass().getName());
            loader1 = loader1.getParent();
        }
        while (true) {
            try {
                MyClassloader loader = new MyClassloader();
                Class clazz = loader.loadClass1("com.tracy.classloader.TestLoad");
                if (clazz == null) {
                    System.out.println("未修改,什么也不做");
                    continue;
                }
                TestLoad t = new TestLoad();
                t.sayHello("");
                Method method = clazz.getMethod("sayHello", String.class);
                method.invoke(clazz.newInstance(), "me");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
}
