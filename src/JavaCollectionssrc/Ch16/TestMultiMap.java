import java.util.*;

public class TestMultiMap {
  public static void main (String args[]) {
    Map map = new HashMap();
    map.put("one", "two");
    map.put("three", "four");
    map.put("five", "six");
    MultiMap multi = new MultiMap(map);
    System.out.println(multi);
    multi.add("five", "seven");
    multi.add("five", "eight");
    multi.add("five", "nine");
    multi.add("five", "ten");
    multi.add("three", "seven");
    System.out.println(multi);
    multi.remove("three");
    System.out.println(multi);
  }
}