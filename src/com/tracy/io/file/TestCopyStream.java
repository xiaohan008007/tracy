/**
 * 
 */
package com.tracy.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author tracy.lu
 * @date:2016年4月7日 上午9:56:40
 * @version :
 */
public class TestCopyStream {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        long t = System.currentTimeMillis();
        File src = new File("F:\\test\\src");
        File dest = new File("F:\\test\\dest4\\");
        copyDirs(src, dest);
        System.out.println("拷贝结束:" + (System.currentTimeMillis() - t));
        // InputStream is = new FileInputStream(src);
        // OutputStream os = new FileOutputStream(dest);
        // byte[] buffer = new byte[1024];
        // while (is.read(buffer) != -1) {
        // os.write(buffer);
        // }
        // os.flush();
        // os.close();
        // is.close();

    }

    private static void copyDirs(File src, File dest) {
        boolean flag = dest.mkdirs();// 确保目标文件夹存在
        System.out.println(dest.getName() + " " + flag);
        if (src.isDirectory()) {
            File[] files = src.listFiles();
            for (File sub : files) {
                copyDirs(sub, new File(dest, sub.getName()));
            }
        } else {
            if (dest.isDirectory()) {
                dest = new File(dest, src.getName());
            }
            InputStream is = null;
            OutputStream os = null;
            try {
                // 拷贝结束:44083 29518
                is = new BufferedInputStream(new FileInputStream(src));
                os = new BufferedOutputStream(new FileOutputStream(dest));
                // is = new FileInputStream(src);
                // os = new FileOutputStream(dest);
                // 拷贝结束:41692 35460
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer, 0, len);
                }
                os.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    if (os != null) os.close();
                    if (is != null) is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
