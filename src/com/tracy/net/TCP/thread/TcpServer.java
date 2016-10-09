/**
 * 
 */
package com.tracy.net.TCP.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.tracy.io.IOCloseUtil;

/**
 * @author tracy.lu
 * @date:2016年4月12日 上午9:55:08
 * @version :
 */
public class TcpServer {

    private List<MyChannel> channels = new ArrayList<TcpServer.MyChannel>();

    public static void main(String[] args) throws IOException {
        new TcpServer().start();
    }

    public void start() throws IOException {

        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket socket = server.accept();
            MyChannel channel = new MyChannel(socket);
            channels.add(channel);
            new Thread(channel).start();
        }

    }

    private class MyChannel implements Runnable {

        private BufferedReader br;
        private BufferedWriter bw;
        private boolean        isRunning = true;
        private String         channelName;     // 管道对象名

        public MyChannel(Socket socket) {
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.channelName = br.readLine();
                this.send("hi " + this.channelName + " 欢迎你登陆聊天室!");
                this.sendToOthers(this.channelName + " 登陆聊天室!~~~");
            } catch (IOException e) {
                IOCloseUtil.close(br, bw);
                channels.remove(this);
                isRunning = false;
            }
        }

        private void send(String msg) {
            try {
                bw.write(msg);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
                IOCloseUtil.close(bw);
                channels.remove(this);
                isRunning = false;
            }
        }

        private String recive() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                IOCloseUtil.close(br);
                channels.remove(this);

                isRunning = false;
            }
            return "";

        }

        private void sendToOthers(String msg) {
            String content = msg;
            String otherName = null;
            if (msg.startsWith("@") && msg.indexOf(":") > -1) {
                otherName = msg.substring(1, msg.indexOf(":"));
                content = msg.substring(msg.indexOf(":") + 1, msg.length());
            }
            for (MyChannel other : channels) {
                if (otherName != null) {
                    if (otherName.equals(other.channelName)) {
                        other.send(this.channelName + ":" + content);
                        break;
                    }
                } else if (other != this) {
                    other.send(content);
                }
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                // send(recive());
                sendToOthers(this.recive());
            }
        }
    }
}
