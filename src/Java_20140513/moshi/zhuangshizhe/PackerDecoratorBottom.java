/**
 * 
 */
package Java_20140513.moshi.zhuangshizhe;

/**
 * @author tracy.lu
 * @date:2014-5-13 下午7:45:33
 * @version :
 */
public class PackerDecoratorBottom extends PacketDecorator {

    /**
     * @param c
     */
    public PackerDecoratorBottom(IPacketCreator c) {
        super(c);
    }

    /*
     * (non-Javadoc)
     * @see Decorator.IPacketCreator#handleContent()
     */
    @Override
    public String handleContent() {
        // TODO Auto-generated method stub
        return component.handleContent() + " == buttom";
    }

}
