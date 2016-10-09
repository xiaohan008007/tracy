import java.util.*;
public class MinMaxTest {
  public static void main(String args[]) {
    String simpsons[] = {"Bart", "Hugo", "Lisa", "Marge",
                         "Homer", "Maggie", "Roy"};
    List list = Arrays.asList(simpsons);

    // Min should be Bart
    System.out.println(Collections.min(list));
    // Max should be Roy
    System.out.println(Collections.max(list));

    Comparator comp = Collections.reverseOrder();

    // Reversed Min should be Roy
    System.out.println(Collections.min(list, comp));
    // Reversed Max should be Bart
    System.out.println(Collections.max(list, comp));
  }
}
