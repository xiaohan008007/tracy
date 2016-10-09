/**
 * 
 */
package Java_20140514.daili;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.MethodProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author tracy.lu
 * @date:2014-5-14 上午11:52:32
 * @version :
 */
public class CglibHeavyMethodInterceptor implements MethodInterceptor {

    public static Map<String, String> cache = new HashMap<String, String>();
    HeavyMethodDemo                   real  = new HeavyMethodDemo();

    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) {
        String v = (String) cache.get(arg2[0]);
        if (v == null) {
            v = real.heavyMethod((Integer) arg2[0]);
            cache.put((String) arg2[0], v);
        }
        return v;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // TODO Auto-generated method stub
        return null;
    }

}
