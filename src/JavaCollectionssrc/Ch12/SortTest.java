import java.util.*;
public class SortTest {
  public static void main(String args[]) throws Exception {
    List list = Arrays.asList(args);
//    Collections.sort(list);
    Collections.sort(list, Collections.reverseOrder());
    for (int i=0, n=list.size(); i<n; i++) {
      if (i != 0) System.out.print(", ");
      System.out.print(list.get(i));
    }
    System.out.println();
  }
}
