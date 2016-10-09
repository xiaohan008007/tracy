/**
 * 
 */
package com.tracy.reflect.proxy.util;

import java.lang.reflect.Method;

/**
 * @author tracy.lu
 * @date:2016年3月29日 上午10:22:57
 * @version :
 */
public interface Advice {

    /**
     * 方法之前执行
     */
    void beforeMethod(Method method);

    /**
     * 方法之后执行
     */
    void afterMethod(Method method);
}
