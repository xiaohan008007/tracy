package netty;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class HelloServer {

    public static void main(String args[]) {

        // Server服务启动器

        ServerBootstrap bootstrap = new ServerBootstrap(

        new NioServerSocketChannelFactory(

        Executors.newCachedThreadPool(),

        Executors.newCachedThreadPool()));

        // 设置一个处理客户端消息和各种消息事件的类(Handler)

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            @Override
            public ChannelPipeline getPipeline() throws Exception {

                return Channels.pipeline(new HelloServerHandler());

            }

        });

        // 开放8000端口供客户端访问。

        bootstrap.bind(new InetSocketAddress(8000));

    }

    private static class HelloServerHandler extends SimpleChannelHandler {

        /**
         * 当有客户端绑定到服务端的时候触发，打印"Hello world, I'm server."
         * 
         * @alia OneCoder
         * @author lihzh
         */

        @Override
        public void channelConnected(ChannelHandlerContext ctx,

        ChannelStateEvent e) {

            System.out.println("Hello world, I'm server.");

        }

        /**
         * 用户接受客户端发来的消息，在有客户端消息到达时触发
         * 
         * @author lihzh
         * @alia OneCoder
         */

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {

            ChannelBuffer buffer = (ChannelBuffer) e.getMessage();

            // System.out.println(buffer.toString(Charset.defaultCharset()));
            // 五位读取
            //
            // while (buffer.readableBytes() >= 5) {
            //
            // ChannelBuffer tempBuffer = buffer.readBytes(5);
            //
            // System.out.println("五位读取:" + tempBuffer.toString(Charset.defaultCharset()));
            //
            // }

            // 读取剩下的信息

            System.out.println("rest:" + buffer.toString(Charset.defaultCharset()) + "_");

        }
    }

}
