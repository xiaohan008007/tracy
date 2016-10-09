import java.util.*;

public class GrowList {
  public static void main (String args[]) {
    List list = Arrays.asList(args);
    list.remove("Hi");
    System.out.println(list);
  }
}