/**
 * 
 */
package Java_20140513.moshi.zhuangshizhe;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午7:38:09
 * @version :
 */
public class PacketBodyCreator implements IPacketCreator {

    @Override
    public String handleContent() {
        return "Content of packet";// 核心数据处理 但无格式
    }
}
