import java.util.*;
public class ShuffleTest {
  public static void main(String args[]) {
    String simpsons[] = {"Bart", "Hugo", "Lisa", "Marge",
                         "Homer", "Maggie", "Roy"};
    List list1 = Arrays.asList(simpsons);
    List list2 = Arrays.asList(simpsons);
    Random rand = new Random(100);
    Collections.shuffle(list1, rand);
    Collections.shuffle(list2, rand);
    System.out.println(list1);
    System.out.println(list2);
  }
}
