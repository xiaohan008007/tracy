import com.objectspace.jgl.*;

public class HashMapTest {
  public static void main(String args[]) {
    HashMap map = new HashMap(true);
    for (int i=0, n=args.length; i<n; i+=2) {
//      Pair pair = new Pair(args[i], args[i+1]);
//      map.add(pair);
//      Pair pair = new Pair(args[i], args[i+1]);
      map.add(args[i], args[i+1]);
    }
    System.out.println(map);
    System.out.println(map.get(args[0]));
    System.out.println(map.get("Foo"));
  }
}