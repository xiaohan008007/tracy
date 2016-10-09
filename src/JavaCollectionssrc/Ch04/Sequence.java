import java.io.*;
import java.util.*;

public class Sequence {
  public static void main(String args[]) throws IOException {
    Vector v = new Vector(3);
    v.add(new FileInputStream("/etc/motd"));
    v.add(new FileInputStream("foo.bar"));
    v.add(new FileInputStream("/temp/john.txt"));
    Enumeration enum = v.elements();
    SequenceInputStream sis = new SequenceInputStream(enum);
    InputStreamReader isr = new InputStreamReader(sis);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    br.close();
  }
}