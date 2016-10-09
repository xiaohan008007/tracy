/**
 * 
 */
package com.tracy.Bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author tracy.lu
 * @date:2016年3月24日 下午7:16:32
 * @version :
 */
public class TestBean {

    /**
     * @param args
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws IntrospectionException, IllegalAccessException,
                                          IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
                                          InstantiationException {
        TestDemo t = new TestDemo("haha", 1);

        String propertyName = "name";
        // 1
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, t.getClass());
        Method getM = pd.getReadMethod();
        Object returnV = getM.invoke(t);
        System.out.println(returnV);

        // 2
        BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : pds) {
            if (propertyDescriptor.getName().equals(propertyName)) {
                Method getM2 = pd.getReadMethod();
                Object returnV2 = getM2.invoke(t);
                System.out.println(returnV2);
                break;
            }
        }

        // 3
        // System.out.println(BeanUtils.getProperty(t, "age"));
        UserDemo ud = new UserDemo();
        BeanUtils.setProperty(ud, "x", 9);
        System.out.println(ud.getX());
        BeanUtils.setProperty(ud, "birthday.time", "111");// 支持级联设置，但birthday不能是null
        System.out.println(BeanUtils.getProperty(ud, "birthday.time"));
        Map<String, Object> map = new HashMap<String, Object>();
        // map={x:"",b:""};
        // BeanUtils.setProperty(map, "ha", "9");
        // System.out.println(map.size());
        BeanUtils.populate(ud, map);
        UserDemo xd = (UserDemo) BeanUtils.cloneBean(ud);
        ud.setX(10);
        System.out.println(xd == ud);
        System.out.println(xd.getX());
        System.out.println(map.size());
    }
}

class TestDemo {

    private String name;
    private int    age;

    public TestDemo(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
