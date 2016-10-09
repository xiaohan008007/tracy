/**
 * 
 */
package com.tracy.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author tracy.lu
 * @date:2016年2月29日 上午11:40:44
 * @version :
 */
public class AfterHandlerImpl extends AfterHandler {

    /*
     * (non-Javadoc)
     * @see com.tracy.aop.aspect.AfterHandler#afterHandler(java.lang.Object, java.lang.reflect.Method,
     * java.lang.Object[])
     */
    @Override
    public void afterHandler(Object proxy, Method method, Object[] params) {
        System.out.println("do something after~~~");

    }

}
