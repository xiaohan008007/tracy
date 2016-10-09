import java.lang.reflect.Array;
public class DoubleArray2 {
  public static void main (String args[]) {
    int array[] = {1, 2, 3, 4, 5};
    System.out.println("Original size: " + array.length);
    System.out.println("New size: " + ((int[])doubleArray(array)).length);
    System.out.println("Original size: " + args.length);
    System.out.println("New size: " + ((String[])doubleArray(args)).length);
    System.out.println("New size: " + ((String[])doubleArray(args))[2]);
  }
  static Object doubleArray(Object original) {
    Object returnValue = null;
    Class type = original.getClass();
    if (type.isArray()) {
      int length = Array.getLength(original);
      Class elementType = type.getComponentType();
      returnValue = Array.newInstance(elementType, length*2);
      System.arraycopy(original, 0, returnValue, 0, length);
    }
    return returnValue;
  }
}