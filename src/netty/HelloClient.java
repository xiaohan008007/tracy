package netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

/**
 * Netty 客户端代码
 * 
 * @author lihzh
 * @alia OneCoder
 * @blog http://www.coderli.com
 */

public class HelloClient {

    public static void main(String args[]) {

        // Client服务启动器

        ClientBootstrap bootstrap = new ClientBootstrap(

        new NioClientSocketChannelFactory(

        Executors.newCachedThreadPool(),

        Executors.newCachedThreadPool()));

        // 设置一个处理服务端消息和各种消息事件的类(Handler)

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            @Override
            public ChannelPipeline getPipeline() throws Exception {

                return Channels.pipeline(new HelloClientHandler());

            }

        });

        // 连接到本地的8000端口的服务端

        bootstrap.connect(new InetSocketAddress(

        "127.0.0.1", 8000));

    }

    private static class HelloClientHandler extends SimpleChannelHandler {

        /**
         * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
         * 
         * @alia OneCoder
         * @author lihzh
         */

        @Override
        public void channelConnected(ChannelHandlerContext ctx,

        ChannelStateEvent e) {

            System.out.println("Hello world, I'm client.");

            // // 将字符串，构造成ChannelBuffer，传递给服务端
            //
            // String msg = "Hello, I'm client.";
            //
            // ChannelBuffer buffer = ChannelBuffers.buffer(msg.length());
            //
            // buffer.writeBytes(msg.getBytes());
            //
            // e.getChannel().write(buffer);

            // 分段发送信息
            sendMessageByFrame(e);
        }

        /**
         * 将<b>"Hello, I'm client."</b>分成三份发送。 <br>
         * Hello, <br>
         * I'm<br>
         * client.<br>
         * 
         * @param e Netty事件
         * @author lihzh
         */

        private void sendMessageByFrame(ChannelStateEvent e) {

            String msgOne = "中文Hello, ";

            String msgTwo = "I'm ";

            String msgThree = "client.";

            e.getChannel().write(tranStr2Buffer(msgOne));

            e.getChannel().write(tranStr2Buffer(msgTwo));

            e.getChannel().write(tranStr2Buffer(msgThree));

        }

        /**
         * 将字符串转换成{@link ChannelBuffer}，私有方法不进行字符串的非空判断。
         * 
         * @param str 待转换字符串，要求非null
         * @return 转换后的ChannelBuffer
         * @author lihzh
         */

        private ChannelBuffer tranStr2Buffer(String str) {

            ChannelBuffer buffer = ChannelBuffers.buffer(str.getBytes().length);

            buffer.writeBytes(str.getBytes());

            return buffer;

        }
    }

}
