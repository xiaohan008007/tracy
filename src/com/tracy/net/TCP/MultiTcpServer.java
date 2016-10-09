/**
 * 
 */
package com.tracy.net.TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tracy.lu
 * @date:2016年4月12日 上午9:55:08
 * @version :
 */
public class MultiTcpServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(6111);
        Executor pool = Executors.newFixedThreadPool(5);
        while (true) {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    Socket socket = null;
                    try {
                        socket = server.accept();
                        System.out.println("end");
                        System.out.println("一个客户端建立连接");
                        String msg = "欢迎连接";
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        bw.write(msg);
                        bw.newLine();
                        bw.flush();
                        while (true) {

                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
        }
        /*
         * OutputStream os = new BufferedOutputStream(socket.getOutputStream()); os.write(msg.getBytes()); os.flush();
         * os.close();
         */
    }
}
