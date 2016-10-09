/**
 * 
 */
package com.tracy.thread.zhangxiaoxiang_20160310;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author tracy.lu
 * @date:2016年3月18日 下午3:00:30
 * @version :
 */
public class ConcurrentModifyException {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add(new User("张三", 1));
        list.add(new User("李四", 2));
        list.add(new User("王五", 3));
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if (u.getName().equals("张三")) {
                it.remove();
            } else {
                System.out.println(u);
            }
        }
    }

    static class User {

        private String name;
        private int    age;

        public User(String name, int age) {
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

        @Override
        public String toString() {
            return String.format("User [name=%s, age=%s]", name, age);
        }

    }

}
