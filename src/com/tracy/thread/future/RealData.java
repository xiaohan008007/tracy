/**
 * 
 */
package thread.future;

/**
 * @author tracy.lu
 * @date:2015年10月22日 下午4:45:55
 * @version :
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(1000);
                System.out.println("处理过程");
            } catch (InterruptedException e) {

            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

}
