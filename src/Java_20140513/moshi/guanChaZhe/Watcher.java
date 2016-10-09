/**
 * 
 */
package Java_20140513.moshi.guanChaZhe;

import java.util.Observable;
import java.util.Observer;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午8:25:23
 * @version :
 */
public class Watcher implements Observer {

    public Watcher(Watched w) {
        w.addObserver(this);
    }

    public void update(Observable ob, Object arg) {
        System.out.println("Data has been changed to: '" + ((Watched) ob).retrieveData() + "'");
    }
}
