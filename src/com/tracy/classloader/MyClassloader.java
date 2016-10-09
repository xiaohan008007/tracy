/**
 * 
 */
package com.tracy.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

/**
 * @author tracy.lu
 * @date:2016年3月28日 下午2:28:38
 * @version :
 */
public class MyClassloader extends ClassLoader {

    private static long lastModified;

    protected Class<?> loadClass1(String name) throws ClassNotFoundException {
        File file = new File(getFileFullPath(name));
        System.out.println(lastModified);
        if (file.lastModified() > lastModified) {
            return findClass(name);
        }
        return null;
    }

    private String getFileFullPath(String name) {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1)
               + name.replaceAll("\\.", "/") + ".class";
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] byteCode = getBytes(getFileFullPath(name));
        return defineClass(null, byteCode, 0, byteCode.length);
    }

    private byte[] getBytes(String filename) {
        byte[] buffer = null;
        File file = new File(filename);
        lastModified = file.lastModified();
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            buffer = new byte[in.available()];
            in.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer;
    }
}
