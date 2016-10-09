/**
 * 
 */
package Java_20140513.moshi.zhuangshizhe;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午7:46:35
 * @version :
 */
public class Main {

    public static void main(String[] args) {

        IPacketCreator ipc = new PacketDecoratorPre(new PackerDecoratorBottom(new PacketBodyCreator()));
        System.out.println(ipc.handleContent());
    }
}
