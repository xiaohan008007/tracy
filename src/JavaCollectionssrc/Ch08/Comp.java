import java.util.*;
public class Comp {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    Set set = new TreeSet(Collections.reverseOrder());
    for (int i=0, n=elements.length; i<n; i++) {
      set.add(elements[i]);
    }
    System.out.println(set);
    System.out.println(((TreeSet)set).comparator());  
  }
}