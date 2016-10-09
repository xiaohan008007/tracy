/**
 * 
 */
package com.tracy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tracy.lu
 * @date:2016年3月25日 上午10:53:40
 * @version :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface MyAnnotation {

    String color() default "黑色";

    String value();

    int[] array() default { 1, 2, 4 };

}
