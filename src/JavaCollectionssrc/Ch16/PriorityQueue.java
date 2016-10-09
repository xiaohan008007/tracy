import java.io.Serializable;
import java.util.*;

public class PriorityQueue extends AbstractList implements Serializable {

  private final static int DEFAULT_NUM_PRIORITIES = 10;
  private final static int MIN_PRIORITY = 0;

  private List queue[];

  public PriorityQueue() {
    this(DEFAULT_NUM_PRIORITIES);
  }

  public PriorityQueue(Collection col) {
    this(col, DEFAULT_NUM_PRIORITIES);
  }

  public PriorityQueue(int numPriorities) {
    this(null, numPriorities);
  }

  public PriorityQueue(Collection col, int numPriorities) {
    if (numPriorities <= 0) {
      throw new IllegalArgumentException(
        "Illegal Number of Priorities: "+ numPriorities);
    }
    queue = new List[numPriorities];
    if (col != null) {
      addAll(col);
    }
  }

  public int size() {
    int size = 0;
    for (int i=0, n=queue.length; i<n; i++) {
      if (queue[i] != null) {
        size += queue[i].size();
      }
    }
    return size;
  }

  public boolean add(Object element) {
    insert(element, MIN_PRIORITY);
    return true;
  }

  public void insert(Object element, int priority) {
    if (queue[priority] == null) {
      queue[priority] = new LinkedList();
    }
    queue[priority].add(element);
    modCount++;
  }

  public void clear() {
    for (int i=0, n=queue.length; i<n; i++) {
      queue[i].clear();
    }
  }

  public Object get(int index) {
    if (index < 0) {
      throw new IllegalArgumentException(
        "Illegal index: "+ index);
    }
    Iterator iter = iterator();
    int pos = 0;
    while (iter.hasNext()) {
      if (pos == index) {
        return iter.next();
      } else {
        pos++;
      }
    }
    return null;
  }

  public Object removeFirst() {
    Iterator iter = iterator();
    Object obj = iter.next();
    iter.remove();
    return obj;
  }

  public Object getFirst() {
    Iterator iter = iterator();
    Object obj = iter.next();
    return obj;
  }

  public Iterator iterator() {
    Iterator iter = new Iterator() {
      int expectedModCount = modCount;
      int priority = queue.length - 1;
      int count = 0;
      int size = size();

      int lastRet = -1; // Used to prevent successive remove() calls

      Iterator tempIter;

      { // Get iterator for highest priority
        if (queue[priority] == null) {
          tempIter = null;
        } else {
          tempIter = queue[priority].iterator();
        }
      }
      
      private final void checkForComodification() {
        if (modCount != expectedModCount) {
          throw new ConcurrentModificationException();
        }
      }

      public boolean hasNext() {
        return count != size();
      }

      public Object next() {
        while (true) {
          if ((tempIter != null) && (tempIter.hasNext())) {
            Object next = tempIter.next();
            checkForComodification();
            lastRet = count++;
            return next;
          } else {
            // Get next iterator
            if (--priority < 0) {
              checkForComodification();
              throw new NoSuchElementException();
            } else {
              if (queue[priority] == null) {
                tempIter = null;
              } else {
                tempIter = queue[priority].iterator();
              }
            }
          }
	}
      }

      public void remove() {
        if (lastRet == -1) {
          throw new IllegalStateException();
        }
        checkForComodification();

        tempIter.remove();
        count--;
        lastRet = -1;
        expectedModCount = modCount;
      }
    };
    return iter;
  }

  public String toString() {
    String returnValue = "{";
    for (int i=0, n=queue.length; i<n; i++) {
      if (i!=0) {
        returnValue += ",";
      }
      returnValue += i + ":";
      if ((queue[i] != null) && (queue[i].size() > 0)) {
        returnValue += queue[i].toString();
      }
    }
    returnValue += "}";
    return returnValue;
  }

}
