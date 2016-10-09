/**
 * 
 */
package com.tracy.io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author tracy.lu
 * @date:2016年4月7日 下午2:41:39
 * @version :
 */
public class TestReader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("F:\\test\\src\\1.txt");
        if (file.isDirectory()) {
            System.out.println("只是个文件夹");
            return;
        }
        Reader is = null;
        try {
            is = new FileReader(file);
            char[] buffer = new char[10];
            int count = 0;
            while ((count = is.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, count));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("关闭输入流失败");
                    e.printStackTrace();
                }
            }
        }

    }

}
