/**
 * 
 */
package Java_20140513.moshi.guanChaZhe;

import java.util.Observable;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午8:23:26
 * @version :
 */
public class Watched extends Observable {

    private String data = "";

    public String retrieveData() {
        return data;
    }

    public void changeData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }

        notifyObservers();
    }
}
