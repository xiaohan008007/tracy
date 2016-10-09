/**
 * 
 */
package com.tracy.io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author tracy.lu
 * @date:2016年4月7日 上午9:51:19
 * @version :
 */
public class TestWriter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("F:\\test\\src\\1.txt");
        Writer os = null;
        try {
            os = new FileWriter(file);
            String text = "人道主义\t\n";
            os.write(text);
            os.append("hah");
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
