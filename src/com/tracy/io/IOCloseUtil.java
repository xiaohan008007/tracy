/**
 * 
 */
package com.tracy.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author tracy.lu
 * @date:2016年4月8日 上午11:48:52
 * @version :
 */
public class IOCloseUtil {

    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    public static <T extends Closeable> void closeAll(T... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
