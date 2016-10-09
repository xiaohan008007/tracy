import com.objectspace.jgl.*;
import com.objectspace.jgl.adapters.*;
import com.objectspace.jgl.algorithms.*;

public class ObjectArrayTest3 {
  static class UnaryPrintFunction implements UnaryFunction {
    public Object execute(Object element) {
      System.out.println(element);
      return null;
    }
  }
  public static void main(String args[]) {
    Sequence sequence = new ObjectArray(args);
    UnaryFunction print = new UnaryPrintFunction();
    Applying.forEach(sequence, print);
  }
}