import java.util.*;
public class Tail {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    SortedSet set = new TreeSet(Arrays.asList(elements));
    System.out.println(set.tailSet("Irish Setter"));
    System.out.println(set.headSet("Irish Setter"));
    System.out.println(set.headSet("Irish Setter\0"));
    System.out.println(set.tailSet("Irish Setter\0"));
    System.out.println(set.subSet("Irish Setter", "Poodle\0"));
    System.out.println(set.subSet("Irish Setter", "Irish Setter\0"));
    System.out.println(set.subSet("Irish Setter", "Irish Setter"));
  }
}