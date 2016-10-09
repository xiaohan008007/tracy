/**
 * 
 */
package com.tracy.io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author tracy.lu
 * @date:2016年4月7日 上午9:51:19
 * @version :
 */
public class TestOutputStream {

    /**
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("F:\\test\\src\\6.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(file, true);
            String text = "人道主义\t\n";
            os.write(text.getBytes("utf-8"));
            os.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
