import java.util.*;

public class DumpProps {
  public static void main (String args[]) {
    Properties props = System.getProperties();
    Iterator iter = props.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry)iter.next();
      System.out.println(entry.getKey() + " --- " + entry.getValue());
    }

    System.out.println("-------");

    Enumeration enum = props.propertyNames();
    while (enum.hasMoreElements()) {
      String key = (String)enum.nextElement();
      System.out.println(key + " --- " + props.getProperty(key));
    }
  }
}