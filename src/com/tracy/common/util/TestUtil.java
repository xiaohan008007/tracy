/**
 * 
 */
package com.tracy.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author tracy.lu
 * @date:2012-6-5 下午4:54:36
 * @version :
 */
public class TestUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "2");
        System.out.println(2 & (3));
        List<User> users = new ArrayList<User>();
        User[] g = { new User(1, "1"), new User(2, "2") };
        users.add(new User(1, "1"));
        users.add(new User(2, "2"));
        System.out.println(CollectionUtils.collect(users, new BeanToPropertyValueTransformer("id")));
    }

    // public static void main(String[] args) {
    // List<String> list=new ArrayList<String>();
    // for (Iterator iterator = list.iterator(); iterator.hasNext();) {
    // String s = (String) iterator.next();
    // iterator.remove();
    //
    // }
    // }
}
