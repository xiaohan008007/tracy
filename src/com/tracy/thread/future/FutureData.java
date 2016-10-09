/**
 * 
 */
package thread.future;

/**
 * @author tracy.lu
 * @date:2015年10月22日 下午4:50:34
 * @version :
 */
public class FutureData implements Data {

    protected RealData realdata = null;
    protected boolean  isReady  = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) return;
        this.realdata = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realdata.result;
    }

}
