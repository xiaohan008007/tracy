/**
 * 
 */
package com.tracy.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author tracy.lu
 * @date:2016年4月8日 下午5:53:27
 * @version :
 */
public class InetDemo {

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress id = InetAddress.getLocalHost();
        System.out.println(id.getHostAddress());// 返回ip
        System.out.println(id.getHostName());// 计算机名
        id = InetAddress.getByName("www.163.com");
        System.out.println(id.getHostAddress());// 返回ip
        System.out.println(id.getHostName());// 输出www.163.com
        id = InetAddress.getByName("183.134.14.143");
        System.out.println(id.getHostAddress());// 返回ip
        System.out.println(id.getHostName());// 输出183.134.14.143
    }

}
