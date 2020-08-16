package search.arrays;

public class LinearSearch {

    /**
     * Linear search for an element by index in an array.
     *
     * @param array array, where we searching
     * @param num target number
     * @return index, where number found
     */
    public static int search(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
