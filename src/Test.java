import search.arrays.BinarySearch;
import search.arrays.InterpolationSearch;

import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int[] array = new Random().ints(0, 1000).limit(1000).toArray();
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        for (int i = 40; i < 60; i++) {
            System.out.print("For " + i + " index = " + InterpolationSearch.search(array, i));
            System.out.println("\tSteps = " + InterpolationSearch.step);
        }

        System.out.println();

        for (int i = 40; i < 60; i++) {
            System.out.print("For " + i + " index = " + BinarySearch.search(array, i));
            System.out.println("\tSteps = " + BinarySearch.step);
        }
    }
}
