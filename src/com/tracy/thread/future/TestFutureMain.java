/**
 * 
 */
package thread.future;

/**
 * @author tracy.lu
 * @date:2015年10月22日 下午5:04:51
 * @version :
 */
public class TestFutureMain {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int v = i;
            new Thread() {

                public void run() {
                    Client client = new Client();
                    Data data = client.request("name" + v);
                    System.out.println(v + "请求完毕");
                    try {
                        System.out.println(v + "开始吃吃喝喝");
                        Thread.sleep(2000);
                        System.out.println(v + "完成吃吃喝喝");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println((v+"数据结果:") + data.getResult());
                }
            }.start();
        }
    }
}
