/**
 * 
 */
package com.tracy.net.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author tracy.lu
 * @date:2016年4月11日 下午6:13:37
 * @version :
 */
public class UdpClient {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // byte[] data = "发送数据".getBytes();
        byte[] data = convert(17.1);
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 9999));
        DatagramSocket client = new DatagramSocket(7777);
        client.send(packet);
        client.close();

    }

    private static byte[] convert(double num) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        dos.writeDouble(num);
        dos.flush();
        byte[] v = bos.toByteArray();
        dos.close();
        return v;
    }

}
