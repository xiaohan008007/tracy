/**
 * 
 */
package guava.collection;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * @author tracy.lu
 * @date:2015年2月10日 上午11:05:03
 * @version :
 */
public class JoinerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String mergeStr = Joiner.on("\t").join(new String[] { "2", "43" });
        List<String> list = Lists.newArrayList();
        list.add("3");
        list.add("8");
        mergeStr = Joiner.on(":").join(list);

        // appendTo
        StringBuilder b = new StringBuilder("sd>>");
        b = Joiner.on(" ").useForNull("null").appendTo(b, 1, 2, null, "d");
        System.out.println(b.toString());

        // Joiner.MapJoiner
        Map<String, String> map = Maps.newHashMap();
        map.put("tom", "1");
        map.put("tim", "2");
        MapJoiner j = Joiner.on("\t").withKeyValueSeparator("=");
        String s = j.join(map);
        System.out.println(s);

        // Using LinkedHashMap so that the original order is preserved
        String expectedString = "Washington D.C=Redskins#New York        City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> test1map = ImmutableMap.of("x", "1", "y", "2");
        List<String> list1 = ImmutableList.of("String", "test");
        System.out.println(Joiner.on("\t").join(list1));
        List<Integer> list2 = Lists.newArrayList(1, 2);
        System.out.println(Joiner.on(";").withKeyValueSeparator("=").join(test1map));
        List<Integer> list3 = ImmutableList.copyOf(list2);
        List<Integer> list4 = list2;
        list4.add(1, 9);

        System.out.println(Joiner.on(" ").join(list2));
        System.out.println(Joiner.on(" ").join(list4));
        System.out.println(Joiner.on(" ").join(list3));
        // Map<String,String> testMap = Maps.newLinkedHashMap();
        // testMap.put("Washington D.C","Redskins");
        // testMap.put("New York City","Giants");
        // testMap.put("Philadelphia","Eagles");
        // testMap.put("Dallas","Cowboys");
        // String returnedString = Joiner.on("#").
        // withKeyValueSeparator("=").join(testMap);

        // 重复key map或set
        Multimap<String, String> map2 = ArrayListMultimap.create();
        map2.put("a", "1");
        map2.put("a", "2");
        map2.put("b", "1");
        List<String> s2 = (List<String>) map2.get("a");
        System.out.println(Joiner.on("\t").join(s2));

        // 双向map value不允许重复 key重复会覆盖
        BiMap<String, Integer> bimap = HashBiMap.create();
        bimap.put("a", 1);
        bimap.put("b", 2);
        bimap.put("c", 3);
        bimap.put("a", 4);
        System.out.println(bimap.get("a"));
        System.out.println(bimap.inverse().get(1));
    }
}
