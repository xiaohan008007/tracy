package com.tracy.serializable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

import com.tracy.common.util.DateUtil;

/**
* @author tracy.lu

* @date:2012-4-23 下午1:45:39
* @version :
*
*/

public class Snippet {
		public static void main(String[] args) throws IOException {
	//		try {
	//	        // Create an appending file handler
	//	        boolean append = true;
	//	        FileHandler handler = new FileHandler(DateUtil.formatDate(new Date())+".log", append);
	//	        // Add to the desired logger
	//	        Logger logger = Logger.getLogger("com.mycompany");
	//	        LogRecord record=new LogRecord(Level.WARNING,"错误信息");
	//	        logger.log(record);
	//	        logger.addHandler(handler);
	//	    } catch (IOException e) {
	//	    }
			 //解决中文乱码  
	        //IO流读取一行  
	        InputStreamReader isr = new InputStreamReader(new FileInputStream("c:\\taotaosou_type\\44.txt"), "utf-8");    
	        BufferedReader read = new BufferedReader(isr);   
	        String value="";
	        while (read.ready()) {  
	           // System.out.println(read.readLine());
	        	String line=read.readLine();
//	        	if(!line.contains("女") && !line.contains("男"))
//	        		line="男 "+line;
	        	value+=","+line;
	        } 
	        System.out.println(value);  
	        //IO流写入一行  
	        //传入true表示按原文件内容后面追加  
//	        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("e:"+DateUtil.formatDate(new Date())+".log",true),"gb2312");  
//	        BufferedWriter bw=new BufferedWriter(osw);  
//	        for (int i = 0; i < 10; i++) {  
//	            bw.write(DateUtil.formatDate(new Date(),DateUtil.FULL_TRADITION_PATTERN)+"【i="+i+"】");  
//	            bw.newLine();  
//	        }  
//	        bw.flush();  
//	        bw.close();  
//	        osw.close();  
		}
}
