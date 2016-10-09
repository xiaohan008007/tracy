import java.util.*;
public class FailExample {
  public static void main (String args[]) {
    List list = Arrays.asList(args);
//    List list = new ArrayList(Arrays.asList(args));
    Iterator i = list.iterator();
    while (i.hasNext()) {
      System.out.println(i.next());
      list.add("Add");
    }
  }
}