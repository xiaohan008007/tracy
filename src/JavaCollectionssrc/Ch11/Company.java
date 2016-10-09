import java.util.*;

public class Company {
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
    Set set = new TreeSet(Arrays.asList(emps));
    System.out.println(set);
    Set set2 = new TreeSet(Collections.reverseOrder());
    set2.addAll(Arrays.asList(emps));
    System.out.println(set2);

    Set set3 = new TreeSet(new EmpComparator());
    for (int i=0, n=emps.length; i<n; i++) {
      set3.add(emps[i]);
    }
    System.out.println(set3);
  }
}