/**
 * 
 */
package com.tracy.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author tracy.lu
 * @date:2016年2月29日 上午11:41:27
 * @version :
 */
public class BeforeHandlerImpl extends BeforeHandler {

    /*
     * (non-Javadoc)
     * @see com.tracy.aop.aspect.BeforeHandler#beforeHandler(java.lang.Object, java.lang.reflect.Method,
     * java.lang.Object[])
     */
    @Override
    public void beforeHandler(Object proxy, Method method, Object[] params) {
        System.out.println("do something before~~~");

    }

}
