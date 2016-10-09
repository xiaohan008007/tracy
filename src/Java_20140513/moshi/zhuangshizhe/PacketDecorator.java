/**
 * 
 */
package Java_20140513.moshi.zhuangshizhe;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午7:39:22
 * @version :
 */
public abstract class PacketDecorator implements IPacketCreator {

    IPacketCreator component;

    public PacketDecorator(IPacketCreator c) {
        this.component = c;
    }

}
