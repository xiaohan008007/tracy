/**
 * 
 */
package com.tracy.net.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author tracy.lu
 * @date:2016年4月12日 上午10:09:24
 * @version :
 */
public class TcpClient {

    /**
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("localhost", 6111);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true) {
            String msg = console.readLine();
            bw.write(msg);
            bw.newLine();
            bw.flush();

            // String msg;
            System.out.println(br.readLine());
            // System.out.println(br.readLine());
            // while ((msg = br.readLine()) != null) {
            // System.out.println(msg);
            // }
        }
        // br.close();
        // bw.close();
        /*
         * InputStream is = new BufferedInputStream(client.getInputStream()); byte[] buffer = new byte[1024]; int len =
         * 0; while ((len = is.read(buffer)) != -1) { System.out.println(new String(buffer, 0, len)); }
         */

    }
}
