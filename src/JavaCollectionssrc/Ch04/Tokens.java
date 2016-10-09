import java.io.*;
import java.util.*;

public class Tokens {
  public static void main(String args[])  {
    StringTokenizer tokenizer = new StringTokenizer("This is a test");
/*
    while (tokenizer.hasMoreElements()) {
      Object o = tokenizer.nextElement();
      System.out.println(o);
    }
*/
    while (tokenizer.hasMoreTokens()) {
      String s = tokenizer.nextToken();
      System.out.println(s);
    }
  }
}