package com.tracy.jdk6.console;

import java.io.Console;

public class ConsoleTest {
         public static void main(String[] args) {
                   Console console = System.console();//获得Console实例
                   if (console != null) {//判断console 是否可用
                            String user = new String(console.readLine("Enter user:")); //读取整行字符
                            String pwd = new String(console.readPassword("Enter passowrd:")); //读取密码,密码输入时不会显示
                            console.printf("User is:" + user + "\n");
                            console.printf("Password is:" + pwd + "\n");
                   } else {
                            System.out.println("Console is unavailable");
                   }
         }
}