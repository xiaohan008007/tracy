import com.sun.java.util.collections.*;
import java.util.Date;

public class Comparators {

  public static Comparator stringComparator() {
    return new Comparator() {

      public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        int len1 = s1.length();
        int len2 = s2.length();
        int n = Math.min(len1, len2);
        char v1[] = s1.toCharArray();
        char v2[] = s2.toCharArray();
        int pos = 0;

        while (n-- != 0) {
          char c1 = v1[pos];
          char c2 = v2[pos];
          if (c1 != c2) {
            return c1 - c2;
          }
          pos++;
        }
        return len1 - len2;
      }
    };
  }

  public static Comparator integerComparator() {
    return new Comparator() {

      public int compare(Object o1, Object o2) {
        int val1 = ((Integer)o1).intValue();
        int val2 = ((Integer)o2).intValue();
        return (val1<val2 ? -1 : (val1==val2 ? 0 : 1));
      }
    };
  }

  public static Comparator dateComparator() {
    return new Comparator() {

      public int compare(Object o1, Object o2) {
        long val1 = ((Date)o1).getTime();
        long val2 = ((Date)o2).getTime();
        return (val1<val2 ? -1 : (val1==val2 ? 0 : 1));
      }
    };
  }
}