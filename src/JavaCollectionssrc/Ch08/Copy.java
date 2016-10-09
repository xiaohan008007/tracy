import java.io.*;
import java.util.*;
public class Copy {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    Set set = new HashSet(Arrays.asList(elements));
    Set set2 = ((Set)((HashSet)set).clone());
    System.out.println(set2);
    FileOutputStream fos = new FileOutputStream("set.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(set);
    oos.close();
    FileInputStream fis = new FileInputStream("set.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Set set3 = (Set)ois.readObject();
    ois.close();
    System.out.println(set3);
  }
}