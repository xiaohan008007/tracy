import java.lang.reflect.Array;
import java.awt.*;

public class ArrayReflection {
  public static void main (String args[]) {
    printType(args);
  }
  private static void printType (Object object) {
    Class type = object.getClass();
    if (type.isArray()) {
      Class elementType = type.getComponentType();
      System.out.println("Array of: " + elementType);
      System.out.println("Array size: " + Array.getLength(object));
    }
  }
}