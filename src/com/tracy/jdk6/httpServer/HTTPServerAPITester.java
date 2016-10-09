package com.tracy.jdk6.httpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;


public class HTTPServerAPITester {
         public static void main(String[] args) {
                   try {
                            HttpServer hs = HttpServer.create(new InetSocketAddress(8888), 0);//设置HttpServer的端口为8888
                            hs.createContext("/lj", new MyHandler());//用MyHandler类内处理到/lj的请求
                            hs.setExecutor(null); // creates a default executor
                            hs.start();
                   } catch (IOException e) {
                            e.printStackTrace();
                   }
         }


 
}