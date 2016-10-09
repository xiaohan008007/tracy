/**
 * 
 */
package com.tracy.annotation;

/**
 * @author tracy.lu
 * @date:2016年3月25日 上午10:08:57
 * @version :
 */
@MyAnnotation(array = { 1, 2 }, value = "爱水水")
public class AnnotationTest {

    /**
     * @param args
     */
    @MyAnnotation("哈哈")
    public static void main(String[] args) {
        if (AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation anno = AnnotationTest.class.getAnnotation(MyAnnotation.class);
            System.out.println(anno.color());
            System.out.println(anno.value());
            System.out.println(anno.array().length);
        }

    }

}
