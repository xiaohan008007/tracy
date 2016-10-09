import java.util.*;

public class ToArrayTest {
  public static void main(String args[]) {
    List l = (Arrays.asList(args));
    Date stuff[]  = (Date[])l.toArray(new Date[0]);
  }
}