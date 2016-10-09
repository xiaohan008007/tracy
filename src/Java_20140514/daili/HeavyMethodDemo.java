/**
 * 
 */
package Java_20140514.daili;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author tracy.lu
 * @date:2014-5-14 上午11:47:45
 * @version :
 */
public class HeavyMethodDemo {

    public String heavyMethod(int num) {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }

    public static HeavyMethodDemo newCacheHeavyMethod() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HeavyMethodDemo.class);
        enhancer.setCallback(new CglibHeavyMethodInterceptor());

    }
}
