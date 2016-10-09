/**
 * 
 */
package com.tracy.aop.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tracy.aop.AbstractHandler;

/**
 * @author tracy.lu
 * @date:2016年2月29日 上午11:27:17
 * @version :
 */
public abstract class BeforeHandler extends AbstractHandler {

    public abstract void beforeHandler(Object proxy, Method method, Object[] params);

    public Object invoke(Object proxy, Method method, Object[] params) throws IllegalAccessException,
                                                                      IllegalArgumentException,
                                                                      InvocationTargetException {
        beforeHandler(proxy, method, params);
        return method.invoke(getTargetObject(), params);
    }
}
