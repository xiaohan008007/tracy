/**
 * 
 */
package com.tracy.net.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author tracy.lu
 * @date:2016年4月11日 下午6:13:23
 * @version :
 */
public class UdpServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramSocket server = new DatagramSocket(9999);
        server.receive(packet);
        byte[] data = packet.getData();
        int len = packet.getLength();
        // System.out.println(new String(data, 0, len));
        System.out.println(convert(data));
        server.close();
    }

    private static double convert(byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(bis));
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}
