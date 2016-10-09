import java.io.Serializable;
import java.util.*;

public class ArraySet extends AbstractSet
    implements Cloneable, Serializable {

  private ArrayList list;

  public ArraySet() {
    list = new ArrayList();
  }

  public ArraySet(Collection col) {
    list = new ArrayList();

    // No need to check for dups if col is a set
    Iterator itor = col.iterator();
    if (col instanceof Set) {
      while (itor.hasNext()) {
        list.add(itor.next());
      }
    } else {
      while(itor.hasNext()) {
        add(itor.next());
      }
    }
  }

  public Iterator iterator() {
    return list.iterator();
  }

  public int size() {
    return list.size();
  }

  public boolean add(Object element) {
    boolean modified;
    if (modified = !list.contains(element)) {
      list.add(element);
    }
    return modified;
  }

  public boolean remove(Object element) {
    return list.remove(element);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public boolean contains(Object element) {
    return list.contains(element);
  }

  public void clear() {
    list.clear();
  }

  public Object clone() {
    try { 
      ArraySet newSet = (ArraySet)super.clone();
      newSet.list = (ArrayList)list.clone();
      return newSet;
    } catch (CloneNotSupportedException e) { 
      throw new InternalError();
    }
  }
}
