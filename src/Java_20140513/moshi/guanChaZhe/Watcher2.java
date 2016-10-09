/**
 * 
 */
package Java_20140513.moshi.guanChaZhe;

import java.util.Observable;
import java.util.Observer;

/**
 * @author tracy.lu
 * @date:2014-5-14 上午10:18:00
 * @version :
 */
public class Watcher2 implements Observer {

    /**
     * 
     */
    public Watcher2(Watched w) {
        w.addObserver(this);
    }

    /*
     * (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Data2 has been changed to: '" + ((Watched) o).retrieveData() + "'");

    }

}
