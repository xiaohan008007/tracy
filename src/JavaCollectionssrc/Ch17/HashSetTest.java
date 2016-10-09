import com.objectspace.jgl.*;

public class HashSetTest {
  public static void main(String args[]) {
    Set set = new HashSet();
    for (int i=0, n=args.length; i<n; i++) {
      set.put(args[i]);
    }
    System.out.println(set);
  }
}