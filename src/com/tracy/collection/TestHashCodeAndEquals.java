/**
 * 
 */
package com.tracy.collection;

import java.util.HashSet;

/**
 * @author tracy.lu
 * @date:2016年3月24日 下午3:09:09
 * @version :
 */
public class TestHashCodeAndEquals {

    /**
     * @param args
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        TestDemo d1 = new TestDemo("莫莫", 1);

        TestDemo d2 = new TestDemo("莫莫", 1);
        System.out.println(d1.hashCode() == d2.hashCode());
        System.out.println(d1.equals(d2));
        System.out.println(d1 == d2);
        System.out.println(Integer.valueOf("10000000", 2));
        HashSet set = new HashSet();
        set.add(d1);
        set.add(d2);
        // d2.age = 2;
        // set.remove(d1);
        // set.remove(d2);
        System.out.println(set.size());

    }
}

class TestDemo {

    public String name;
    public int    age;

    public TestDemo(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj) return true;
    // if (obj == null) return false;
    // if (getClass() != obj.getClass()) return false;
    // TestDemo other = (TestDemo) obj;
    // if (age != other.age) return false;
    // if (name == null) {
    // if (other.name != null) return false;
    // } else if (!name.equals(other.name)) return false;
    // return true;
    // }

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
