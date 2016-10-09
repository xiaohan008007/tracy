import com.sun.java.util.collections.*;
import java.util.Date;

public class IntTest {
  public static void main(String args[]) {
    List u2 = new ArrayList();
    u2.add(new Integer(1));
    u2.add(new Integer(12));
    u2.add(new Integer(13));
    u2.add(new Integer(14));
    u2.add(new Integer(10));

    Comparator comp = Comparators.integerComparator();
    Collections.sort(u2, comp);
    System.out.println(u2);

    List u3 = new ArrayList();
    u3.add(new Date("10/11/1999"));
    u3.add(new Date("11/12/1998"));
    u3.add(new Date("9/4/2000"));

    Comparator comp2 = Comparators.dateComparator();
    Collections.sort(u3, comp2);
    System.out.println(u3);
  }
}