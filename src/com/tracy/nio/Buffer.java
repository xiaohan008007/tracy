/**
 * 
 */
package com.tracy.nio;

import java.nio.IntBuffer;

/**
 * @author tracy.lu
 * @date:2016年4月25日 下午6:58:47
 * @version :
 */
public class Buffer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(100);
        System.out.println(buffer.position() + " " + buffer.limit() + " " + buffer.capacity());

        int[] data = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        buffer.put(100);
        buffer.put(data);
        System.out.println(buffer.position() + " " + buffer.limit() + " " + buffer.capacity());
        buffer.flip();// 重设缓存区
        System.out.println(buffer.position() + " " + buffer.limit() + " " + buffer.capacity());
        // buffer.put(data);
        // buffer.put(data);
        // System.out.println(buffer.position() + " " + buffer.limit() + " " + buffer.capacity());
        // while (buffer.hasRemaining()) {
        // System.out.println(buffer.get());
        // }
        buffer.position(2);
        buffer.limit(4);
        IntBuffer slice = buffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            int item = slice.get(i);
            slice.put(item - 100);
            System.out.println(item);
        }
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        // buffer.flip();// 重设缓存区
        // while (buffer.hasRemaining()) {
        // System.out.println(buffer.get());
        // }
    }
}
