import java.util.*;

public class Backwards {
  public static void main (String args[]) {
    Employee emps[] = {
      new Employee("Finance", "Degree, Debbie"),
      new Employee("Finance", "Grade, Geri"),
      new Employee("Finance", "Extent, Ester"),
      new Employee("Engineering", "Measure, Mary"),
      new Employee("Engineering", "Amount, Anastasia"),
      new Employee("Engineering", "Ratio, Ringo"),
      new Employee("Sales", "Stint, Sarah"),
      new Employee("Sales", "Pitch, Paula"),
      new Employee("Support", "Rate, Rhoda"),
    };
    SortedSet set = new TreeSet(Arrays.asList(emps));
    System.out.println(set);

    try {
      Object last = set.last();
      boolean first = true;
      while (true) {
        if (!first) {
          System.out.print(", ");
        }
        System.out.println(last);
        last=set.headSet(last).last();
      }
    } catch (NoSuchElementException e) {
      System.out.println();
    }

Set subset = set.headSet(emps[4]);
subset.add(emps[5]);

  }
}