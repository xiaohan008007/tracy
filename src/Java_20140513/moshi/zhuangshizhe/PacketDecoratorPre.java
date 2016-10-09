/**
 * 
 */
package Java_20140513.moshi.zhuangshizhe;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午7:43:28
 * @version :
 */
public class PacketDecoratorPre extends PacketDecorator {

    /**
     * @param c
     */
    public PacketDecoratorPre(IPacketCreator c) {
        super(c);
    }

    /*
     * (non-Javadoc)
     * @see Decorator.IPacketCreator#handleContent()
     */
    @Override
    public String handleContent() {
        return "header ++ " + component.handleContent();
    }

}
