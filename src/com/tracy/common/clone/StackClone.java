/**
 * 
 */
package com.tracy.common.clone;

import java.util.Arrays;

/**
 * @author tracy.lu

 * @date:2012-6-15 下午3:45:44
 * @version :
 *
 */
public class StackClone {

	private Object[] elements;
	private int size=0;
	private static final int Default_inital_capacity=16;
	
	public StackClone(){
		this.elements=new Object[Default_inital_capacity];
	}
	
	public void push(Object e){
	}
	private void ensureCapacity(){
		if(elements.length==size)
			elements=Arrays.copyOf(elements, 2*size+1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
