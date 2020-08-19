package search.arrays;

import java.util.Arrays;

public class ExponentialSearch {

    public static int search(int[] array, int key) {
        //if value is at position one
        if(array[0] == key) {
            return 0;
        }
        //find the range for the binary search
        int i = 1;
        while (i < array.length && array[i] <= key) {
            i = i * 2;
        }
        //now call the binary search
        return Arrays.binarySearch(array, (i / 2), Math.min(i, array.length), key);
    }
}
