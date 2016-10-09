import com.objectspace.jgl.*;
import com.objectspace.jgl.adapters.*;
import com.objectspace.jgl.algorithms.*;

public class ObjectArrayTest2 {
  public static void main(String args[]) {
    Sequence sequence = new ObjectArray(args);
    Printing.println(sequence);
  }
}