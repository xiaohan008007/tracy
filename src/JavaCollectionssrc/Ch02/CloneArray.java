public class CloneArray {
  public static void main (String args[]) {
    int array1[] = {1, 2, 3, 4, 5};
    int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("Original size: " + array1.length);
    System.out.println("New size: " + cloneArray(array1).length);
    System.out.println("Original size: " + array2.length);
    System.out.println("New size: " + cloneArray(array2).length);
  }
  static int[] cloneArray(int original[]) {
    return (int[])original.clone();
  }
}