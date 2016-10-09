import java.util.*;
import java.io.*;

public class Load {
  public static void main (String args[]) throws Exception {
    Properties p = new Properties();
    p.load(new FileInputStream("colon.txt"));
    p.list(System.out);
  }
}