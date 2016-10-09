package mina;
/**
 * @author Himi
 */
 
import java.io.IOException;
import java.net.InetSocketAddress;
 
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
 
public class MinaServer {
 
    /**
     * @param args
     */
 
    public static void main(String[] args) {
        //创建一个非阻塞的server端Socket ，用NIO
        SocketAcceptor acceptor = new NioSocketAcceptor();
 
        /*---------接收字符串---------*/
//      //创建一个接收数据过滤器
//      DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//      //设定过滤器一行行(/r/n)的读取数据
//      chain.addLast("mychin", new ProtocolCodecFilter(new TextLineCodecFactory()   ));
        /*---------接收对象---------*/
        //创建接收数据的过滤器
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //设定这个过滤器将以对象为单位读取数据
        ProtocolCodecFilter filter= new ProtocolCodecFilter(new ObjectSerializationCodecFactory());
        chain.addLast("objectFilter",filter);
 
        //设定服务器消息处理器
        acceptor.setHandler(new ClientMinaServerHanlder());
        //服务器绑定的端口
        int bindPort = 9988;
        //绑定端口，启动服务器
        try {
            acceptor.bind(new InetSocketAddress(bindPort));
        } catch (IOException e) {
            System.out.println("Mina Server start for error!"+bindPort);
            e.printStackTrace();
        }
        System.out.println("Mina Server run done! on port:"+bindPort);
    }
}