/**
 * 
 */
package com.tracy.collection;

import java.util.Arrays;

/**
 * @author tracy.lu
 * @date:2016年3月30日 下午7:09:36
 * @version :
 */
public class MyArrayList {

    // ArrayList<E>
    private Object[]              arr          = null;

    private int                   size;

    private static final Object[] EMPTY_DATA   = {};

    private static final int      DEFAULT_SIZE = 10;

    public MyArrayList() {
        arr = EMPTY_DATA;
    }

    public MyArrayList(int size) {
        if (size < 0) {
            try {
                throw new IllegalAccessException("illegal Capacity:" + size);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        arr = new Object[size];
    }

    public void remove(int index) {
        rangeCheck(index);
        arr[index] = null;
        int numMoved = arr.length - index - 1;
        if (numMoved > 0) System.arraycopy(arr, index + 1, arr, index, numMoved);
        arr[--size] = null;// let gc do
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("数据越界:" + index);
        }
    }

    public void add(Object obj) {
        initCapacity(size + 1);
        arr[size++] = obj;
    }

    private void initCapacity(int minCapacity) {
        if (arr == EMPTY_DATA) {
            minCapacity = Math.max(DEFAULT_SIZE, minCapacity);
        }
        if (minCapacity > size) {
            grow(minCapacity);
        }

    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = arr.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        } else if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = Integer.MAX_VALUE;
        }
        Arrays.copyOf(arr, newCapacity);
    }
}
