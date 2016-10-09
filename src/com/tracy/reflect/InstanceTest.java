/**
 * 
 */
package com.tracy.reflect;

import java.util.Properties;

/**
 * @author tracy.lu
 * @date:2016年3月10日 下午4:33:43
 * @version :
 */
public class InstanceTest {

    private static Properties pro = null;

    public static Properties getInstance() {
        if (pro == null) {
            pro = new Properties();
        }
        return pro;
    }
}
