/**
 * 
 */
package com.tracy.common.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tracy.lu

 * @date:2012-5-31 下午1:44:49
 * @version :
 *
 */
public class ArrayAlg {

	/**
	 * 
	 */
	public ArrayAlg() {
		// TODO Auto-generated constructor stub
	}
	public  static <T> T getMiddle(T[] a){
		return a[a.length/2];
	}
	public static void main(String[] args) {
		//String[] names={"2","3","4"};
		double[] ages={14.3,23.1,11.1};
		//String middle=getMiddle(names);
		double age=getMiddle(ages);
		System.out.println(middle);
		Min(new String[]{});
	}
	public static <T extends Comparable<? super T>> T Min(T[] a){
		T small=a[0];
		if(small.compareTo((T)"1")==-1){
			
		}
		return small;
	}
}
