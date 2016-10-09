/**
 * 
 */
package com.tracy.UseAbleUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;

import com.tracy.common.util.User;

/**
 * @author tracy.lu
 * @date:2016年5月19日 下午4:17:25
 * @version :
 */
public class CollectionUtil {

    /**
     * 用于日志直接打印集合的某个字段
     * 
     * @param collection
     * @param fieldName
     * @return
     */
    public static Collection<?> collect(Collection<?> collection, String fieldName) {
        return CollectionUtils.collect(collection, new BeanToPropertyValueTransformer(fieldName));

    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        // User[] g = { new User(1, "1"), new User(2, "2") };
        users.add(new User(1, "1"));
        users.add(new User(2, "2"));
        System.out.println(collect(users, "id"));
    }
}
