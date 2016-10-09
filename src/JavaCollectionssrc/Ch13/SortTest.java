import java.net.*;
import java.io.*;
import java.util.*;
public class SortTest {
  public static void main(String args[]) throws Exception {
    Arrays.sort(args);
    for (int i=0, n=args.length; i<n; i++) {
      System.out.println(args[i]);
    }

    System.out.println();
    int array[] = {2, 5, -2, 6, -3};
    Arrays.sort(array);
    for (int i=0, n=array.length; i<n; i++) {
      System.out.println(array[i]);
    }

    System.out.println();
    int array2[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
    Arrays.sort(array2, 3, 7);
    for (int i=0, n=array2.length; i<n; i++) {
      System.out.println(array2[i]);
    }
    int foo[] = new int[3];
    Arrays.sort(foo);
    URL url1 = new URL("http://www.foo.com");
    URL url2 = new URL("http://www.bar.com");
    URL urls[] = {url1, url2};
//    Arrays.sort(urls);
  }
}