import java.util.*;
public class SearchTest {
  public static void main(String args[]) throws Exception {
    int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};

    // Ensure array sorted
    Arrays.sort(array);
    printArray("Sorted array", array);

    // Search for element in array
    int index = Arrays.binarySearch(array, 2);
    System.out.println("Found 2 @ " + index);

    // Search for element not in array
    index = Arrays.binarySearch(array, 1);
    System.out.println("Didn't find 1 @ " + index);

    // Insert
    int newIndex = -index - 1;
    array = insertElement(array, 1, newIndex);
    printArray("With 1 added", array);

  }
  private static void printArray(String message, int array[]) {
    System.out.println(message + ": [length: " + array.length + "]");
    // Print out sorted array elements
    for (int i=0, n=array.length; i<n; i++) {
      if (i != 0) System.out.print(", ");
      System.out.print(array[i]);
    }
    System.out.println();
  }
  private static int[] insertElement(int original[], int element, int index) {
    int length = original.length;
    int destination[] = new int[length+1];
    System.arraycopy(original, 0, destination, 0, index);
    destination[index] = element;
    System.arraycopy(original, index, destination, index+1, length-index);
    return destination;
  }
}