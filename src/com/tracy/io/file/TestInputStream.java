/**
 * 
 */
package com.tracy.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tracy.lu
 * @date:2016年4月6日 下午7:17:03
 * @version :
 */
public class TestInputStream {

    /**
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("F:\\test\\src\\1.txt");
        if (file.isDirectory()) {
            System.out.println("只是个文件夹");
            return;
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] buffer = new byte[100];
            int count = 0;
            while ((count = is.read(buffer)) != -1) {
                System.out.println(new String(buffer));
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
