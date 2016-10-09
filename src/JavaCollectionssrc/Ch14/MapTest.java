import java.util.*;

public class MapTest {
  public static void main (String args[]) {
    Map map = new ArrayMap(13);
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
    System.out.println(map);
    System.out.println(map.keySet());
    System.out.println(map.values());
  }
}