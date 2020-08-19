package search.arrays;

public class LinearSearch {
    public static int step;

    /**
     * Linear search for an element by index in an array.<br>
     * Time complexity = O(n)
     *
     * @param array array, where we searching
     * @param num target number
     * @return index, where number found
     */
    public static int search(int[] array, int num) {
        step = 0;

        for (int i = 0; i < array.length; i++) {
            step++;

            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
