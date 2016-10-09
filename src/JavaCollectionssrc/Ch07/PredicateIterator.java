import java.util.*;
class PredicateIterator implements Iterator {
  Iterator iter;
  Predicate pred;
  Object next;
  boolean doneNext = false;
  public PredicateIterator(Iterator iter, Predicate pred) {
    this.iter = iter;
    this.pred = pred;
  }
  public void remove() {
    throw new UnsupportedOperationException();
  }
  public boolean hasNext() {
    doneNext = true;
    boolean hasNext;
    while (hasNext = iter.hasNext()) {
      next = iter.next();
      if (pred.predicate(next)) {
        break;
      }
    }
    return hasNext;
  }
  public Object next() {
    if (!doneNext) {
      boolean has = hasNext();
      if (!has) {
        throw new NoSuchElementException();
      }
    }
    doneNext = false;
    return next;
  }
}