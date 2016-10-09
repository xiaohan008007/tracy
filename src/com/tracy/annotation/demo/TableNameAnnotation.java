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
 * @date:2016年5月18日 下午5:18:36
 * @version :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableNameAnnotation {

    String value();
}
