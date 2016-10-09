import java.util.*;
public class CopyTest {
  public static void main(String args[]) throws Exception {
    List wineMakers = Arrays.asList(new String[] {"Ugolin", "Cesar"});
    List barFlies = Arrays.asList(new String[] {"Barney", "Carl", "Lenny"});
    Collections.copy(barFlies, wineMakers);
    System.out.println(barFlies);
    Collections.copy(wineMakers, barFlies);
  }
}
