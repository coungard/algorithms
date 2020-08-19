import search.arrays.*;
import search.text.KnuthMorrisPrathPatternSearch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {
    private static int[] array;
    private static final int BOUND = 100_000_000;

    public static void main(String[] args) {
        array = new Random().ints(0, Integer.MAX_VALUE).limit(BOUND).toArray();
        Arrays.sort(array);

        int[] values = new Random().ints(0, 100000).limit(100000).toArray();

        exponentialTest(values);
        binaryTest(values);
    }

    private static void exponentialTest(int[] values) {
        System.out.println("Exponential search...");
        long before = System.currentTimeMillis();

        for (int value : values) {
            int index = ExponentialSearch.search(array, value);
        }
        System.out.println("Exponential elapsed: " + (System.currentTimeMillis() - before));
        System.out.println("\n");
    }

    private static void knutMorrisPrathTest() {
        String pattern = "AAABAAA";
        String text = "ASBNSAAAAAABAAAAABAAAAAGAHUHDJKDDKSHAAJF";

        List<Integer> foundIndexes = KnuthMorrisPrathPatternSearch.performKMPSearch(text, pattern);

        if (foundIndexes.isEmpty()) {
            System.out.println("Pattern not found in the given text String");
        } else {
            System.out.println("Pattern found in the given text String at positions: "
                    + foundIndexes.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
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
        System.out.println("Binary search...");
        long before = System.currentTimeMillis();

        for (int value : values) {
            int index = BinarySearch.search(array, value);
//            System.out.print("For value " + value + " steps = " + BinarySearch.step + " (index = " + index + "), ");
        }
        System.out.println("Binary elapsed: " + (System.currentTimeMillis() - before));
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
