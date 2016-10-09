import java.util.*;

public class BackStates {
  public static void main (String args[]) {
    TreeMap map = new TreeMap();
    map.put("Virginia", "Richmond");
    map.put("Massachusetts", "Boston");
    map.put("New York", "Albany");
    map.put("Maryland", "Annapolis");
    map.put("Rhode Island", "Providence");
    map.put("Connecticut", "Hartford");
    map.put("Delaware", "Dover");
    map.put("New Hampshire", "Concord");
    map.put("North Carolina", "Raleigh");
    map.put("South Carolina", "Columbia");
    map.put("New Jersey", "Trenton");
    map.put("Pennsylvania", "Harrisburg");
    map.put("Georgira", "Atlanta");

if (!map.isEmpty()) {
  Object last = map.lastKey();
  boolean first = true;
  do {
    if (!first) {
      System.out.print(", ");
    }
    System.out.print(last);
    last=map.headMap(last).lastKey();
    first=false;
  } while (last != map.firstKey());
  System.out.println();
}
  }
}