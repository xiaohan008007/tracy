import java.util.*;

public class EnumerationIterator {
  public static Iterator iterator(final Enumeration enum) {
    return new Iterator() {
      public boolean hasNext() {
        return enum.hasMoreElements();
      }

      public Object next() {
        return enum.nextElement();
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  public static void main (String args[]) {
    Vector v = new Vector(Arrays.asList(args));
    Enumeration enum = v.elements();
    Iterator itor = EnumerationIterator.iterator(enum);
    while (itor.hasNext()) {
      System.out.println(itor.next());
    }
  }
}