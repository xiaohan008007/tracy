import java.util.*;

public class Sample {
  public static void main (String args[]) {
    Hashtable hash = new Hashtable(89);
    hash.put("one", "two");
    hash.put("two", "three");
    hash.put("three", "four");
    hash.put("four", "five");
    System.out.println(hash);
    System.out.println(hash.size());
    Enumeration enum = hash.keys();
    while (enum.hasMoreElements()) {
     String key = (String)enum.nextElement();
     System.out.println(key + " : " + hash.get(key));
    }
    Set set = hash.entrySet();
    Iterator it = set.iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry)it.next();
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}