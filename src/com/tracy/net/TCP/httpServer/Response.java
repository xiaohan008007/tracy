/**
 * 
 */
package com.tracy.net.TCP.httpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author tracy.lu
 * @date:2016年4月21日 下午6:24:28
 * @version :
 */
public class Response {

    private static final String BLANK = " ";
    private static final String CRLF  = "\r\n";

    private OutputStream        os;
    private StringBuilder       content;
    private int                 len;

    public Response(Socket socket) throws IOException {
        os = socket.getOutputStream();
        content = new StringBuilder();
    }

    public Response print(String info) {
        content.append(info);
        len += content.toString().getBytes().length;
        return this;
        // StringBuilder content = new StringBuilder();
        // content.append("<html><head><title>测试response</title></head>");
        // content.append("<body>" + name + "</body></html>");
        // return content;
    }

    public Response println(String info) {
        content.append(info).append(CRLF);
        len += content.toString().getBytes().length;
        return this;
    }

    public StringBuilder setResCode(int code) {
        StringBuilder sb = new StringBuilder("HTTP/1.1").append(BLANK);
        switch (code) {
            case 200:
                sb.append(code).append(BLANK).append("OK").append(CRLF);
                break;
            case 404:
                sb.append(code).append(BLANK).append("NOT FOUND").append(CRLF);
                break;
            case 500:
                sb.append(code).append(BLANK).append("SERVER ERROR").append(CRLF);
                break;
            default:
                break;
        }
        sb.append("Content-Type:").append("text/html,charset=GBK").append(CRLF);
        sb.append("Content-Length:").append(content.toString().getBytes().length).append(CRLF);
        sb.append(CRLF);
        sb.append(content);
        return sb;
    }

    public void printOut(int code) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(setResCode(code).toString());
        bw.newLine();
        bw.flush();
    }
}
