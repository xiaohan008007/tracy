/**
 * 
 */
package JavaCollectionssrc.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author tracy.lu
 * @date:2013-8-7 下午1:53:53
 * @version :
 */

/**
 * @author my
 */
public class CollectionToArray {

    public static void main(String[] args) {
        Collection collection1 = new ArrayList();// 创建一个集合对象 
        collection1.add("000");// 添加对象到Collection集合中   
        collection1.add("111");
        collection1.add("222");
        // System.out.println("集合collection1的大小：" + collection1.size());
        // System.out.println("集合collection1的内容：" + collection1);
        // collection1.remove("000");// 从集合collection1中移除掉 "000" 这个对象    
        // System.out.println("集合collection1移除 000 后的内容：" + collection1);
        // System.out.println("集合collection1中是否包含000 ：" + collection1.contains("000"));
        // System.out.println("集合collection1中是否包含111 ：" + collection1.contains("111"));
        // Collection collection2 = new ArrayList();
        // collection2.addAll(collection1);// 将collection1 集合中的元素全部都加到collection2中 
        // System.out.println("集合collection2的内容：" + collection2);
        // collection2.clear();// 清空集合 collection1 中的元素 
        // System.out.println("集合collection2是否为空 ：" + collection2.isEmpty());// 将集合collection1转化为数组       
        // System.out.println("集合collection1是否为空 ：" + collection1.isEmpty());// 将集合collection1转化为数组
        // Object s[] = collection1.toArray();
        // for (int i = 0; i < s.length; i++) {
        // System.out.println(s[i]);
        // }
        Iterator<Object> it = collection1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
