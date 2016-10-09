import java.util.*;
public class PredTest {
  static Predicate pred = new Predicate() {
    public boolean predicate(Object o) {
      return o.toString().startsWith("Hi");
    }
  };
  public static void main (String args[]) {
    List list = Arrays.asList(args);
    Iterator i1 = list.iterator();
    Iterator i = new PredicateIterator(i1, pred);
    while (i.hasNext()) {
      System.out.println(i.next());
    }
  }
}