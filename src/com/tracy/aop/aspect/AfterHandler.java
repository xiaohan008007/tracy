/**
 * 
 */
package com.tracy.aop.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tracy.aop.AbstractHandler;

/**
 * @author tracy.lu
 * @date:2016年2月29日 上午11:37:24
 * @version :
 */
public abstract class AfterHandler extends AbstractHandler {

    public abstract void afterHandler(Object proxy, Method method, Object[] params);

    public Object invoke(Object proxy, Method method, Object[] params) throws IllegalAccessException,
                                                                      IllegalArgumentException,
                                                                      InvocationTargetException {
        Object result = method.invoke(getTargetObject(), params);
        afterHandler(proxy, method, params);
        return result;
    }
}
