/**
 * 
 */
package ch.ethz.ssh2.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


/**
 * @author tracy.lu
 * @date:2012-8-16 下午8:39:45
 * @version :
 */
public class ClassUtils extends org.apache.commons.lang.ClassUtils{

    private static void validateParameters(Object a, Object b) {
        if (a == null || b == null) {
            throw new java.lang.IllegalArgumentException("parameters cannot be null");
        }
    }

    public static boolean isSameType(Class a, Class b) {
        validateParameters(a, b);
        if (a.getName().equals(b.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSameType(Object a, Object b) {
        validateParameters(a, b);
        return isSameType(a.getClass(), b.getClass());
    }

    public static boolean isSystemClass(Class<?> c) {
        return c.getName().startsWith("java.");
    }

    // 这里提供了一个validateParameters用于所有方法中检测参数为null时可能引发的NullPointerException。
    // isSystemClass用于判断是否为JDK提供的标准类
    //
    // 2、获取Field

    public static Field getField(Object obj, String name) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Field[] getNoStaticNorFinalFieldArray(Object obj) {
        return getNoStaticNorFinalFieldList(obj).toArray(new Field[] {});
    }

    public static List<Field> getNoStaticNorFinalFieldList(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> nostaticFieldList = new ArrayList<Field>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                nostaticFieldList.add(field);
            }
        }
        return nostaticFieldList;
    }

    public static Field[] getNoStaticFieldArray(Object obj) {
        return getNoStaticFieldList(obj).toArray(new Field[] {});
    }

    public static List<Field> getNoStaticFieldList(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> nostaticFieldList = new ArrayList<Field>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!Modifier.isStatic(field.getModifiers())) {
                nostaticFieldList.add(field);
            }
        }
        return nostaticFieldList;
    }

    public Field getNoStaticNorFinalField(Object obj, String name) throws NoSuchFieldException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                if (field.getName().equals(name)) {
                    return field;
                }
            }
        }
        throw new NoSuchFieldException(String.format("No such field: %s", name));
    }

    // 3、PackageUtils，ClassUtils提供了对Class内部的操作，而PcakageUtils则提供了对整个Class的操作。

}
