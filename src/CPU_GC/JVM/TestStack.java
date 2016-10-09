/**
 * 
 */
package CPU_GC.JVM;


/**
 * @author tracy.lu
 * @date:2015年11月9日 下午2:47:31
 * @version :
 */
public class TestStack {

    private static int count = 0;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of stack is " + count);
            e.printStackTrace();
        }
    }
}
