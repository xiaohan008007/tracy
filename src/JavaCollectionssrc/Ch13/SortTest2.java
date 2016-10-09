import java.util.*;
public class SortTest2 {
  public static void main(String args[]) throws Exception {
    Comparator comp = Collections.reverseOrder();
    Arrays.sort(args, comp);
    for (int i=0, n=args.length; i<n; i++) {
      System.out.println(args[i]);
    }
  }
}