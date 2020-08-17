import search.arrays.BinarySearch;
import search.arrays.InterpolationSearch;
import search.arrays.JumpSearch;
import search.arrays.LinearSearch;

import java.util.Arrays;
import java.util.Random;

public class Test {
    private static int[] array;
    private static final int BOUND = 1_000_000;

    public static void main(String[] args) {
        array = new Random().ints(0, BOUND).limit(BOUND).toArray();
        Arrays.sort(array);

        int[] values = new Random().ints(0, BOUND).limit(100).toArray();

        linearTest(values);
        binaryTest(values);
        jumpTest(values);
        interpolationTest(values);

    }

    private static void jumpTest(int[] values) {
        System.out.println("\nJump search...");
        long before = System.currentTimeMillis();

        for (int value : values) {
            int index = JumpSearch.search(array, value);
            System.out.print("For value " + value + " steps = " + JumpSearch.step + " (index = " + index + "), ");
        }
        System.out.println("\nJump elapsed: " + (System.currentTimeMillis() - before));
        System.out.println();
    }

    private static void interpolationTest(int[] values) {
        System.out.println("\nInterpolation search...");
        long before = System.currentTimeMillis();

        for (int value : values) {
            int index = InterpolationSearch.search(array, value);
            System.out.print("For value " + value + " steps = " + InterpolationSearch.step + " (index = " + index + "), ");
        }
        System.out.println("\nInterpolation elapsed: " + (System.currentTimeMillis() - before));
        System.out.println();
    }

    private static void binaryTest(int[] values) {
        System.out.println("\nBinary search...");
        long before = System.currentTimeMillis();

        for (int value : values) {
            int index = BinarySearch.search(array, value);
            System.out.print("For value " + value + " steps = " + BinarySearch.step + " (index = " + index + "), ");
        }
        System.out.println("\nBinary elapsed: " + (System.currentTimeMillis() - before));
        System.out.println("\n");
    }

    private static void linearTest(int[] values) {
        System.out.println("\nLinear search...");
        long before = System.currentTimeMillis();

        for (int value : values) {
            int index = LinearSearch.search(array, value);
            System.out.print("For value " + value + " steps = " + LinearSearch.step + " (index = " + index + "), ");
        }
        System.out.println("\nLinear elapsed: " + (System.currentTimeMillis() - before));
        System.out.println("");
    }
}
