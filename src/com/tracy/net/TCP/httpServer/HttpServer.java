/**
 * 
 */
package com.tracy.net.TCP.httpServer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author tracy.lu
 * @date:2016年4月20日 上午10:45:28
 * @version :
 */
public class HttpServer {

    // POST /index.html HTTP/1.1
    // Accept: application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg,
    // application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*
    // Accept-Language: zh-CN
    // User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)
    // Content-Type: application/x-www-form-urlencoded
    // Accept-Encoding: gzip, deflate
    // Host: 127.0.0.1:9999
    // Content-Length: 20
    // Connection: Keep-Alive
    // Cache-Control: no-cache
    //
    // name=haha&pwd=123456

    private static final String BLANK      = " ";
    private static final String CRLF       = "\r\n";
    private ServerSocket        server;
    private boolean             isShutDown = false;

    public static void main(String[] args) throws IOException {
        new HttpServer().start();
        // ServerSocket server = new ServerSocket(9999);
        // Socket socket = server.accept();
        //
        // new Thread(new Dispatcher(socket)).start();
        // Request request = new Request(socket);
        // Response response = new Response(socket);
        // Servlet servlet = new Servlet();
        // servlet.service(request, response);
        // response.printOut(200);

        // HTTP/1.1 200 OK
        // Accept-Ranges: bytes
        // Age: 1772
        // Cache-Control: max-age=7200
        // CC_CACHE: TCP_IMS_HIT
        // Content-Encoding: gzip
        // Content-Length: 7019
        // Content-Type: text/css
        // Date: Wed, 20 Apr 2016 05:40:50 GMT
        // ETag: "5715a82c-938f"
        // Expires: Wed, 20 Apr 2016 07:40:50 GMT
        // Last-Modified: Tue, 19 Apr 2016 03:38:20 GMT
        // Powered-By-ChinaCache: HIT from 010051b3H5.6
        // Server: nginx
        // Vary: Accept-Encoding

    }

    public void start(int port) {
        try {
            server = new ServerSocket(port);
            this.accept();
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }

    public void start() {
        start(9999);
    }

    public void stop() {
        isShutDown = true;
        try {
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void accept() {
        try {
            while (!isShutDown) {
                new Thread(new Dispatcher(server.accept())).start();// server.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }
}
