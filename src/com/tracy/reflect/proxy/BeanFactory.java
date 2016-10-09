/**
 * 
 */
package com.tracy.reflect.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import com.tracy.reflect.proxy.util.Advice;

/**
 * @author tracy.lu
 * @date:2016年3月29日 上午11:03:18
 * @version :
 */
public class BeanFactory {

    static private Properties properties = new Properties();

    public static void load(InputStream is) {

        try {
            properties.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // String
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("aaa");
        // list.isEmpty()
    }

    public static Object getBean(String name) {
        String classname = (String) properties.get(name);
        try {
            Class clazz = Class.forName(classname);
            Object returnV = clazz.newInstance();
            if (returnV instanceof ProxyBean) {
                ProxyBean bean = (ProxyBean) returnV;
                Advice advice = (Advice) Class.forName((String) properties.get(name + ".advice")).newInstance();
                Object target = Class.forName((String) properties.get(name + ".target")).newInstance();
                bean.setAdvice(advice);
                bean.setTarget(target);
                returnV = bean.getProxy();
            }
            return returnV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
