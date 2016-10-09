/**
 * 
 */
package com.tracy.util.test;

import com.tracy.util.CopyObjectUtils;

/**
 * @author tracy.lu
 * @date:2015年12月23日 下午3:30:24
 * @version :
 */
public class TestCopy {

    public static void main(String[] args) {
        TestModel1 model1 = new TestModel1();
        model1.setId(123);
        TestModel2 model2 = new TestModel2();
        model2.setName("说丹佛");
        System.out.println(model2.getId() + model2.getName());
        CopyObjectUtils.copyProperties(model1, null);

        System.out.println(model2.getId() + model2.getName());
    }
}
