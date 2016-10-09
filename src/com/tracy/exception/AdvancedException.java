/**
 * 
 */
package com.tracy.exception;
/**
 * @author tracy.lu

 * @date:2012-5-24 下午2:58:57
 * @version :
 *
 */
public class AdvancedException {

	/**
	 * @throws Throwable 
	 * 
	 */
	public AdvancedException() throws Throwable {
		try{
		Integer.parseInt("S");
		}catch (Exception e) {
			Throwable se=new FileNotException("文件找不到");
			se.initCause(e);
			throw se;
		}
	}
	public static void do3()throws Throwable {
		try{
		Integer.parseInt("S");
		}catch (Exception e) {
			Throwable se=new FileNotException("文件找不到");
			se.initCause(e);
			throw se;
		}
	}
	public static void main(String[] args) {
		try {
			do3();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

}
