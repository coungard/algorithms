package search.arrays;

public class BinarySearch {
    public static int step;

    /**
     * Binary search for an element by index in an array. Work only for sorted arrays. <br>
     * Time complexity = O(log(n))
     *
     * @param array array, where we searching
     * @param num target number
     * @return index, where number found
     */
    public static int search(int[] array, int num) {
        int low = 0;
        int high = array.length - 1;
        int index = -1;

        step = 0;

        while (low <= high) {
            step++;
            int mid = (low + high) / 2;

            if (array[mid] == num) {
                return mid;
            }
            if (array[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
