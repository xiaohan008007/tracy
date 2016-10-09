/**
 * 
 */
package com.tracy.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author tracy.lu
 * @date:2016年4月7日 下午6:14:16
 * @version :
 */
public class TestDataStreamAndByteArraySteam {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        write(read());

    }

    public static void write(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
        int num1 = dis.readInt();
        long num2 = dis.readLong();
        String text = dis.readUTF();
        System.out.println(num1 + " " + num2 + " " + text);
    }

    public static byte[] read() throws IOException {
        int num = 100;
        long num1 = 40l;
        String text = "收到";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        dos.writeInt(num);
        dos.writeLong(num1);
        dos.writeUTF(text);
        dos.flush();
        byte[] re = bos.toByteArray();
        dos.close();
        bos.close();
        return re;

    }

}
