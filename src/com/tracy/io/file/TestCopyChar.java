/**
 * 
 */
package com.tracy.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author tracy.lu
 * @date:2016年4月7日 上午9:56:40
 * @version :
 */
public class TestCopyChar {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File src = new File("F:\\test\\src\\src2\\");
        File dest = new File("F:\\test\\dest\\");
        copyDirs(src, dest);
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
        if (src.isDirectory()) {
            boolean flag = dest.mkdirs();// 确保目标文件夹存在
            System.out.println(dest.getName() + " " + flag);
            File[] files = src.listFiles();
            for (File sub : files) {
                copyDirs(sub, new File(dest, sub.getName()));
            }
        } else {
            // Reader is = null;
            BufferedReader is = null;
            BufferedWriter os = null;
            try {
                is = new BufferedReader(new FileReader(src));
                os = new BufferedWriter(new FileWriter(dest));
                // char[] buffer = new char[1024];
                /*
                 * int len = 0; while ((len = is.read(buffer)) != -1) { os.write(buffer, 0, len); }
                 */
                String line = null;
                while ((line = is.readLine()) != null) {
                    os.write(line);
                    // os.append("\r\n");
                    os.newLine();
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
