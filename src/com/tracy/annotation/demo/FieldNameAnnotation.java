/**
 * 
 */
package com.tracy.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tracy.lu
 * @date:2016年5月18日 下午5:22:02
 * @version :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldNameAnnotation {

    String fieldName();

    String fieldType();

    int fieldLength() default 0;

    String defaultValue() default "";

    String comment() default "";
}
