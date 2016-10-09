import java.util.*;
public class Init {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Shindler's List", "Waiting List",
      "Shopping List", "Wish List", "Wine List"};
    List list = new ArrayList(Arrays.asList(elements));
    System.out.println(list);
  }
}