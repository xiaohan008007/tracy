import java.util.Enumeration;
import com.objectspace.jgl.*;
import com.objectspace.jgl.adapters.*;

public class ObjectArrayTest {
  public static void main(String args[]) {
    Sequence sequence = new ObjectArray(args);

    Enumeration enum = sequence.elements();
    while (enum.hasMoreElements()) {
      System.out.println(enum.nextElement());
    }
  }
}