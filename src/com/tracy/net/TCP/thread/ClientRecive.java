/**
 * 
 */
package com.tracy.net.TCP.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.tracy.io.IOCloseUtil;

/**
 * @author tracy.lu
 * @date:2016年4月14日 下午7:13:29
 * @version :
 */
public class ClientRecive implements Runnable {

    private BufferedReader br;
    private boolean        isRunning = true;

    public ClientRecive(Socket socket) {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            IOCloseUtil.close(br);
        }
    }

    public void revice() {
        try {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            IOCloseUtil.close(br);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            revice();
        }

    }

}
