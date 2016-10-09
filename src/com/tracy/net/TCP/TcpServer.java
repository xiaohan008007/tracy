/**
 * 
 */
package com.tracy.net.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tracy.lu
 * @date:2016年4月12日 上午9:55:08
 * @version :
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6111);
        server.setReuseAddress(true);// 该选项表示是否允许重用服务器所绑定的地址
        Socket socket = server.accept();
        System.out.println("一个客户端建立连接");
        String msg = "欢迎连接";
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("服务器:" + msg);
        bw.newLine();
        bw.flush();
        /*
         * OutputStream os = new BufferedOutputStream(socket.getOutputStream()); os.write(msg.getBytes()); os.flush();
         * os.close();
         */
    }
}
