import com.objectspace.jgl.*;
import com.objectspace.jgl.algorithms.*;
import com.objectspace.jgl.functions.*;
import com.objectspace.jgl.predicates.*;

public class AlgTest {
  public static void main(String args[]) {
    Array array = new Array();
    array.add(new Integer(10));
    array.add(new Integer(-10));
    array.add(new Integer(23));
    Integer product = (Integer)Applying.inject(
      array, new Integer(1), new TimesNumber());
    System.out.println("Array = " + array + " / Product = " + product);
    Array posArray = (Array)Filtering.select(array, new PositiveNumber());
    Integer product2 = (Integer)Applying.inject(
      posArray, new Integer(1), new TimesNumber());
    System.out.println("Array = " + posArray + " / Pos Product = " + product2);
  }
}