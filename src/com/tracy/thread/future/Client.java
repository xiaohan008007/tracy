/**
 * 
 */
package thread.future;

/**
 * @author tracy.lu
 * @date:2015年10月22日 下午4:44:33
 * @version :
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {

            public void run() {
                RealData realdata = new RealData(queryStr);
                future.setRealData(realdata);
            }
        }.start();
        return future;
    }
}
