/**
 * 
 */
package Java_20140513.moshi.guanChaZhe;

import java.util.Observer;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午8:26:14
 * @version :
 */
public class Main {

    public static void main(String[] args) {
        Watched watched = new Watched();

        Observer watcher = new Watcher(watched);
        // new Watcher2(watched);

        watched.changeData("In C, we create bugs.");
        watched.changeData("In Java, we inherit bugs.");
        watched.changeData("In Java, we inherit bugs.");
        watched.changeData("In Visual Basic, we visualize bugs.");
    }
}
