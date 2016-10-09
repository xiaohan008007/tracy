/**
 * 
 */
package com.tracy.collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author tracy.lu
 * @date:2016年3月31日 上午11:47:56
 * @version :hashmap底层实现：数组+链表
 */
public class MyHashMap {

    private static final int ARR_SIZE  = 100;
    private LinkedList[]     linkedArr = new LinkedList[ARR_SIZE];

    private int hash(Object key) {
        return key.hashCode() % ARR_SIZE;
    }

    public Object get(Object key) {
        LinkedList<?> linkedList = linkedArr[hash(key)];
        if (linkedList != null) {
            for (Object object : linkedList) {
                ElementEntry e = (ElementEntry) object;
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        LinkedList<ElementEntry> linkedList = linkedArr[hash(key)];
        if (linkedList == null) {
            linkedList = new LinkedList<ElementEntry>();
            linkedList.add(new ElementEntry(key, value));
            linkedArr[index] = linkedList;
        } else {
            for (ElementEntry e : linkedList) {
                if (e.key.equals(key)) {
                    e.value = value;
                    return;
                }
            }
            linkedList.add(new ElementEntry(key, value));
        }
    }

    class ElementEntry {

        private Object key;
        private Object value;

        public ElementEntry(Object key, Object value) {
            super();
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        String str = "def";
        // str.substring(beginIndex)
        String str2 = str.replace("d", "o");
        System.out.println(str2);
        Set<String> set = new HashSet<String>();
        String a = new String("1");
        String b = new String("1");
        set.add(a);
        set.add(b);
        System.out.println(set.size());
        MyHashMap map = new MyHashMap();
        map.put("he", "中说");
        map.put("增强", "手动");
        map.put("he", "手动");

        System.out.println(map.get("he"));
    }
}
