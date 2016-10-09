/**
 * 
 */
package com.tracy.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author tracy.lu
 * @date:2016年4月7日 下午4:13:02
 * @version :字节流转字符流
 */
public class TestInputStreamReader {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // byte[] buf = "行收到".getBytes();
        // InputStream bis = new BufferedInputStream(new ByteArrayInputStream(buf));
        // int len;
        // byte[] flush = new byte[1024];
        // while ((len = bis.read(flush)) != -1) {
        // System.out.println(new String(flush, 0, len));
        // }
        File file = new File("F:\\test\\src\\1.txt");
        // BufferedReader read = new BufferedReader(new FileReader(file));
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        String line;
        while ((line = read.readLine()) != null) {
            System.out.println(line);
        }
        read.close();
    }
}
