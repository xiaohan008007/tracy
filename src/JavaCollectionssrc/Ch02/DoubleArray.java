public class DoubleArray {
  public static void main (String args[]) {
    int array1[] = {1, 2, 3, 4, 5};
    int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("Original size: " + array1.length);
    System.out.println("New size: " + doubleArray(array1).length);
    System.out.println("Original size: " + array2.length);
    System.out.println("New size: " + doubleArray(array2).length);
  }
  static int[] doubleArray(int original[]) {
    int length = original.length;
    int newArray[] = new int[length*2];
    System.arraycopy(original, 0, newArray, 0, length);
    return newArray;
  }
}