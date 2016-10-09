package CPU_GC.JVM.OOM;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author zzm
 */
public class HeapOOM {

    static class OOMObject {
    }

    // public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException,
    // IllegalAccessException {
    // final char[] value1 = { 1, 2 };// new char[1];
    // value1[1] = 3;
    // for (char c : value1) {
    // System.out.println((int) c);
    // }
    // // 创建字符串"Hello World"， 并赋给引用s
    // String s = "Hello World";
    // String tm = s.concat("a");
    // System.out.println(tm);
    // // s = new String();
    // System.out.println("s = " + s); // Hello World
    //
    // // 获取String类中的value字段
    // Field valueFieldOfString = String.class.getDeclaredField("value");
    //
    // // 改变value属性的访问权限
    // valueFieldOfString.setAccessible(true);
    //
    // // 获取s对象上的value属性的值
    // char[] value = (char[]) valueFieldOfString.get(s);
    //
    // // 改变value所引用的数组中的第5个字符
    // value[5] = '_';
    //
    // System.out.println("s = " + s); // Hello_World
    // // String a = new String("对象还在内存中!");
    // // WeakReference b = new WeakReference(a);
    // // // System.out.println(b.get());
    // // // 移除强引用
    // // a = null;
    // // // 呼叫gc...
    // // System.gc();
    // // System.out.println(b.get());
    // // // 对象被回收了么？
    // // if (b.get() == null) System.out.println("被回收了!");
    // // else System.out.println(b.get());
    // // System.exit(0);
    //
    // // String a = "1";
    // // // String b = a;
    // // WeakReference<String> b = new WeakReference<String>(a);
    // // a = null;
    // // System.gc();
    // // System.out.println(a);
    // // System.out.println(b.get());
    // }

    // public static void main(String[] args) {
    //
    // List<OOMObject> list = new ArrayList<OOMObject>();
    // int i = 0;
    // while (true) {
    // list.add(new OOMObject());
    // System.out.println((i++) + " 剩余内存" + getFreeMemory() + "M");
    // }
    // }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
        String str="";
        Class c = Class.forName("java.lang.String");
        c.getField("value").get;
        // String a = c.newInstance();
        Field[] fields = c.getDeclaredFields();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        // int a = 0;
        // System.out.println(returnMy(a));
    }

    public static int returnMy(int a) {
        try {
            a = 1;
            String b = null;
            if (b.equals("")) System.out.println();
            // return a;
        } catch (Exception e) {
            a = 2;
            return a;
        } finally {
            a = 3;
        }
        return a;
    }

    // get available memory in MB
    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory() / (1024 * 1024);
    }
}
