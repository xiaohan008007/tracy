/**
 * 
 */
package com.tracy.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.tracy.reflect.proxy.util.Advice;

/**
 * @author tracy.lu
 * @date:2016年3月29日 上午11:10:01
 * @version :
 */
public class ProxyBean {

    private Object target;
    private Advice advice;

    public Object getProxy() {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                                              new InvocationHandler() {

                                                  @Override
                                                  public Object invoke(Object proxy, Method method, Object[] args)
                                                                                                                  throws Throwable {
                                                      advice.beforeMethod(method);
                                                      Object o = method.invoke(target, args);
                                                      advice.afterMethod(method);
                                                      return o;
                                                  }
                                              });
        return proxy;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

}
