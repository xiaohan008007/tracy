import java.util.*;

public class TestPriorityQueue {
  public static void main (String args[]) {
    List list = Arrays.asList(args);
    PriorityQueue queue = new PriorityQueue(list);
    System.out.println(queue);
    queue = new PriorityQueue(5);
    try {
      System.out.println(queue.removeFirst());
    } catch (NoSuchElementException e) {
      System.out.println("Got expected Exception");
    }
    queue.insert("Help", 2);
    queue.insert("Me", 2);
    queue.insert("Whazzup", 1);
    queue.insert("Out", 2);
    queue.insert("Of", 2);
    queue.insert("Here", 2);
    System.out.println(queue);
    System.out.println(queue.removeFirst());
    System.out.println(queue);
    queue.addAll(list);
    System.out.println(queue);
    while (queue.size() != 0) {
      System.out.println(queue.removeFirst());
    }
  }
}