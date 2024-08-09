package utils;

public class ArrayUtil {

    public static void displayIntArray(int[] res) {
        if (res.length == 0) {
            System.out.println("The result set is empty");
            return;
        }

        for (int num : res) {
            System.out.print(" " + num);
        }
        System.out.println();
    }
}
