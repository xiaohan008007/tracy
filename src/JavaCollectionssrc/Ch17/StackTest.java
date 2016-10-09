import com.objectspace.jgl.*;

public class StackTest {
  public static void main(String args[]) {
    Stack stack = new Stack();
    for (int i=0, n=args.length; i<n; i++) {
      stack.push(args[i]);
    }
    System.out.println(stack);
    System.out.println("Pop elements: ");
    while (!stack.isEmpty()) {
      System.out.println("\t" + stack.pop());
    }
  }
}