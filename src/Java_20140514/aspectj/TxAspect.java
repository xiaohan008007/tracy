/**
 * 
 */
package Java_20140514.aspectj;
/**
* @author tracy.lu

* @date:2014-5-14 下午3:25:01
* @version :
*
*/



    public  Aspect TxAspect 
     { 
     // 指定执行 Hello.sayHello() 方法时执行下面代码块
     void around():call(void Hello.sayHello()){System.out.println("开始事务 ...");proceed();System.out.println("事务结束 ...");}
     }
