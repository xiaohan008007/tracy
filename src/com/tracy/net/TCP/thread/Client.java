/**
 * 
 */
package com.tracy.net.TCP.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author tracy.lu
 * @date:2016年4月14日 下午7:16:11
 * @version :
 */
public class Client {

    /**
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("localhost", 9999);
        System.out.println("请输入用户名:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String channelName = br.readLine();
        new Thread(new ClientSend(client, channelName)).start();
        new Thread(new ClientRecive(client)).start();

    }
}
