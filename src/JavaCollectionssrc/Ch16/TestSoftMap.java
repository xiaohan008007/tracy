import java.util.*;

public class TestSoftMap {
  public static void main (String args[]) {
    final Map map = new SoftHashMap();
    map.put(new String("one"), "two");
    map.put(new String("three"), "four");
    map.put(new String("five"), "six");
    boolean end = false;
    for (int i=0; i<1000000000; i++) {
      Map maps = new HashMap(map);
      System.out.println("Size: " + map.size());
      System.out.println("Elements: " + map);
      if (end) {
        break;
      }
      if (map.size() == 0) {
        end = true;
      }
    }
  }
}