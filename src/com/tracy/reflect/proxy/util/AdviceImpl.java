/**
 * 
 */
package com.tracy.reflect.proxy.util;

import java.lang.reflect.Method;

/**
 * @author tracy.lu
 * @date:2016年3月29日 上午10:28:11
 * @version :
 */
public class AdviceImpl implements Advice {

    private long startTime;

    @Override
    public void beforeMethod(Method method) {
        startTime = System.currentTimeMillis();

    }

    @Override
    public void afterMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + "  spend time:" + (endTime - startTime));

    }

}
