package JavaCollectionssrc.Ch02;

public class ArrayArgs2 {

    public static void main(String args[]) {
        try {
            int i = 0;
            do {
                System.out.println("Arg " + i + ": " + args[i++]);
            } while (true);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }
}
