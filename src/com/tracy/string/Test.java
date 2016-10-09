package com.tracy.string;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        File.separator
        // StringBuilder sb = new StringBuilder("1234");
        // sb.delete(0, 1);
        // System.out.println(sb.toString());
        // sb.delete(start, end)
        char[] value = { '1', '2', '3', '4' };
        int count = value.length;
        int end = 2, start = 1;
        int len = end - start;
        if (len > 0) {
            System.arraycopy(value, start + len, value, start, count - end);
            count -= len;
        }
        for (char c : value) {

            System.out.println(c);
        }
        System.out.println(new String(value, 0, count));
        // System.out.println(count);
        // MyClass myClass1 = new MyClass();
        // MyClass myClass2 = new MyClass();
        // System.out.println(myClass1.i);
        // System.out.println(myClass1.j);
        // System.out.println(myClass2.i);
        // System.out.println(myClass2.j);

    }
}

class MyClass {

    public final double  i = Math.random();
    public static double j = Math.random();
}
