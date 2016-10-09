/**
 * 
 */
package com.tracy.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.tracy.reflect.proxy.util.Advice;
import com.tracy.reflect.proxy.util.AdviceImpl;

/**
 * @author tracy.lu
 * @date:2016年3月29日 上午9:26:21
 * @version :
 */
public class JDKProxyTest {

    /**
     * @param args
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
                                          NoSuchMethodException, SecurityException, IllegalArgumentException,
                                          InvocationTargetException {

        /*
         * Class<?> c = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class); Constructor[]
         * constructors = c.getConstructors(); for (Constructor constructor : constructors) {
         * System.out.println(constructor); } Constructor constructor = c.getConstructor(InvocationHandler.class);
         * Collection collection = (Collection) constructor.newInstance(new InvocationHandler() { List target = new
         * ArrayList();
         * @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //
         * System.out.println(method.getName() + " " + Arrays.asList(args)); return method.invoke(target, args); } });
         * System.out.println(collection.toString()); collection.add("1"); collection.add("2");
         * System.out.println(collection.size());
         */
        final List target = new ArrayList();
        final Advice advice = new AdviceImpl();
        Collection collection = (Collection) getProxy(target, advice);
        System.out.println(collection.getClass().getName());
        collection.add("1");
        System.out.println(collection.size());

        // 模拟spring 用工厂方法+配置文件
        // System.out.println(JDKProxyTest.class.getResourceAsStream("aop.properties"));
        BeanFactory.load(JDKProxyTest.class.getResourceAsStream("aop.properties"));
        // BeanFactory.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("aop.properties"));
        Object o = BeanFactory.getBean("xxx");
        System.out.println(o.getClass().getName());
    }

    /**
     * @param target
     * @param advice
     * @return 返回代理
     */
    private static Object getProxy(final Object target, final Advice advice) {
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
}
