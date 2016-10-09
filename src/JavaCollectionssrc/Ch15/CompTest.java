import com.sun.java.util.collections.*;

public class CompTest {
  public static void main(String args[]) {
    List u2 = new ArrayList();
    u2.add("Beautiful Day");
    u2.add("Stuck In A Moment You Can't Get Out Of");
    u2.add("Elevation");
    u2.add("Walk On");
    u2.add("Kite");
    u2.add("In A Little While");
    u2.add("Wild Honey");
    u2.add("Peace On Earth");
    u2.add("When I Look At The World");
    u2.add("New York");
    u2.add("Grace");

    Comparator comp = Comparators.stringComparator();
    Collections.sort(u2, comp);
    System.out.println(u2);

    Arrays.sort(args, comp);
    System.out.print("[");
    for (int i=0, n=args.length; i<n; i++) {
      if (i != 0) System.out.print(", ");
      System.out.print(args[i]);
    }
    System.out.println("]");
  }
}