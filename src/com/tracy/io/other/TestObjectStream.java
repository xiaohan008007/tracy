/**
 * 
 */
package com.tracy.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.tracy.io.IOCloseUtil;

/**
 * @author tracy.lu
 * @date:2016年4月7日 下午7:18:04
 * @version :
 */
public class TestObjectStream {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // 方式1 写到文件 再从文件读取
        // serializable("F:\\test\\src\\entity.txt");
        // DemoEntity de = (DemoEntity) read("F:\\test\\src\\entity.txt");
        // 方式2 写内存数组 再读取数组
        DemoEntity de = (DemoEntity) readArray(serializable2Array());
        System.out.println(de.getName() + " " + de.getAge());
    }

    public static Object read(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(path))));
        Object o = oos.readObject();
        oos.close();
        return o;
    }

    public static void serializable(String path) throws FileNotFoundException, IOException {
        DemoEntity de = new DemoEntity("宇文化及", 19);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(path))));
        oos.writeObject(de);
        oos.flush();
        oos.close();
    }

    public static Object readArray(byte[] data) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
        Object o = oos.readObject();
        oos.close();
        return o;
    }

    public static byte[] serializable2Array() throws FileNotFoundException, IOException {
        DemoEntity de = new DemoEntity("宇文化及", 19);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
        oos.writeObject(de);
        oos.flush();
        byte[] re = bos.toByteArray();
        // oos.close();
        // bos.close();
        // 关闭流工具类
        IOCloseUtil.close(oos, bos);
        return re;
    }
}
