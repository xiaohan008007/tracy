/**
 * 
 */
package com.tracy.net.TCP.httpServer;

import java.io.IOException;
import java.net.Socket;

/**
 * @author tracy.lu
 * @date:2016年4月21日 下午7:35:49
 * @version :
 */
public class Dispatcher implements Runnable {

    private Request  request;
    private Response response;
    private Socket   socket;
    private int      code = 200;

    public Dispatcher(Socket client) {
        socket = client;
        try {
            request = new Request(socket);
            response = new Response(socket);
        } catch (IOException e) {
            code = 500;
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Servlet servlet = new Servlet();
        servlet.service(request, response);
        try {
            response.printOut(code);
        } catch (IOException e1) {
            e1.printStackTrace();
            try {
                response.printOut(500);
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (socket != null) try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
