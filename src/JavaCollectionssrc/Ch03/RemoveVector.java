import java.util.Vector;
public class RemoveVector {
  static boolean removeAll(Vector v, Object e) {
    Vector v1 = new Vector();
    v1.add(e);
    return v.removeAll(v1);
  }
  public static void main (String args[]) {
    Vector v = new Vector();
    for (int i=0, n=args.length; i<n; i++) {
      v.add(args[i]);
    }
    System.out.println(removeAll(v, args[0]));
    System.out.println(v);
  }
}