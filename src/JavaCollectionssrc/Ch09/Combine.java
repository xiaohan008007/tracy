import java.util.*;
public class Combine {
  public static void main (String args[]) {
    // Create/fill collection
    List list = new ArrayList();
    list.add("Play List");
    list.add("Check List");
    list.add("Mailing List");
    // Add in middle
    list.add(1, "Guest List");
  }
}