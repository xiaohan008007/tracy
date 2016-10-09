/**
 * 
 */
package com.tracy.net.TCP.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.apache.commons.lang.StringUtils;

import com.tracy.io.IOCloseUtil;

/**
 * @author tracy.lu
 * @date:2016年4月14日 下午7:06:10
 * @version :
 */
public class ClientSend implements Runnable {

    private BufferedWriter bw;
    private BufferedReader console;
    private boolean        isRunning = true;
    private String         channelName;

    public ClientSend() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public ClientSend(Socket socket, String channelName) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.channelName = channelName;
            this.send(channelName);
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            IOCloseUtil.close(bw, console);
        }
    }

    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            IOCloseUtil.close(bw, console);
        }
        return null;
    }

    public void send(String channelName) {
        try {
            String msg = channelName;
            if (StringUtils.isNotBlank(msg)) {
                bw.write(msg);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            IOCloseUtil.close(bw, console);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send(getMsgFromConsole());
        }

    }

}
