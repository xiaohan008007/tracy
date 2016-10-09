import java.util.*;

public class SetTest {
  public static void main (String args[]) {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    Set set = new ArraySet(Arrays.asList(elements));
    Iterator iter = set.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}
