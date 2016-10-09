/**
 * 
 */
package com.tracy.classloader.testHotLoad_20160927.entity;

/**
 * @author tracy.lu
 * @date:2016年9月27日 下午2:51:13
 * @version :
 */
public class MyManager implements BaseManager {

    /*
     * (non-Javadoc)
     * @see com.tracy.classloader.test_20160927.BaseManager#logic()
     */
    @Override
    public void logic() {
        String a = "99";
        int x = Integer.parseInt(a);
        System.out.println(x);

    }

}
