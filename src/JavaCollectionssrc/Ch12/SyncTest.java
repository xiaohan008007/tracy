import java.util.*;
public class SyncTest {
  public static void main(String args[]) {
    Set simpsons = new HashSet();
    simpsons.add("Bart");
    simpsons.add("Hugo");
    simpsons.add("Lisa");
    simpsons.add("Marge");
    simpsons.add("Homer");
    simpsons.add("Maggie");
    simpsons.add("Roy");
    simpsons = Collections.synchronizedSet(simpsons);
    synchronized(simpsons) {
      Iterator iter = simpsons.iterator();
      while (iter.hasNext()) {
        System.out.println(iter.next());
      }
    }
    Map map = Collections.synchronizedMap(new HashMap(89));
    Set set = map.entrySet();
    synchronized(map) {
      Iterator iter = set.iterator();
      while (iter.hasNext()) {
        System.out.println(iter.next());
      }
    }
  }
}