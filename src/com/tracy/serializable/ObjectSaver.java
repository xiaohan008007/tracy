package com.tracy.serializable;
import java.io.*;

import java.util.Date;

/**

 * 对象的序列化和反序列化测试类.    

 * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>

 * @version 1.0

 * Creation date: 2007-9-15 - 下午21:45:48

 */

public class ObjectSaver {

       /**

        * @param args

        * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>

        * Creation date: 2007-9-15 - 下午21:45:37

        */

       public static void main(String[] args) throws Exception {

              ObjectOutputStream out = new ObjectOutputStream

                     (new FileOutputStream("D:\\objectFile.obj"));

              //序列化对象
              Customer customer = new Customer("阿蜜果", 24);

              out.writeObject("你好!");

              out.writeObject(new Date());

              out.writeObject(customer);

              out.writeInt(123); //写入基本类型数据

              out.close();

              //反序列化对象

              ObjectInputStream in = new ObjectInputStream

                     (new FileInputStream("D:\\objectFile.obj"));

              System.out.println("obj1=" + (String) in.readObject());

              System.out.println("obj2=" + (Date) in.readObject());

              Customer obj3 = (Customer) in.readObject();

              System.out.println("obj3=" + obj3);

              int obj4 = in.readInt();

              System.out.println("obj4=" + obj4);

              in.close();

       }

}

class Customer implements Serializable {

       private String name;

       private int age;

       public Customer(String name, int age) {

              this.name = name;

              this.age = age;

       }

       public String toString() {

              return "name=" + name + ", age=" + age;

       }

}