/**
 * 
 */
package com.tracy.io.other;

import java.io.Serializable;

/**
 * @author tracy.lu
 * @date:2016年4月7日 下午7:18:22
 * @version :
 */
public class DemoEntity implements Serializable {

    private transient String name;
    private int              age;

    public DemoEntity(String name, int age) {
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
