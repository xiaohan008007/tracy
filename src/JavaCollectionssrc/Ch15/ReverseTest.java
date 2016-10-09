import com.sun.java.util.collections.*;

public class ReverseTest {
  public static void main(String args[]) {
    List simpsons = new ArrayList();
    simpsons.add("Bart");
    simpsons.add("Hugo");
    simpsons.add("Lisa");
    simpsons.add("Marge");
    simpsons.add("Homer");
    simpsons.add("Maggie");
    simpsons.add("Roy");
    Comparator comp = Collections.reverseOrder();
    Collections.sort(simpsons);
    System.out.println(simpsons);
  }
}