package search.arrays;

public class InterpolationSearch {
    public static int step;

    /**
     * Interpolation search for an element by index in an array.
     * Position calculated by the formula: <br>
     * <strong> startIndex + ((lastIndex-startIndex) / (array[lastIndex]
     * - array[startIndex]) * (elementToSearch - array[startIndex])) </strong>
     * Used for evenly spaced elements. <br>
     *
     * Time complexity = O(log(log(n))), for evenly distributed array, O(n) - for others.
     *
     * @param array array, where we searching
     * @param key target number
     * @return index, where number found
     */
    public static int search(int[] array, int key) {
        step = 0;
        int low = 0;
        int high = (array.length - 1);

        while ((low <= high) && (key >= array[low]) && (key <= array[high])) {
            step++;

            if (low == high || array[high] == array[low]) {
                if (array[high] == key)
                    return high;
                else
                    return -1;
            }

            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = low + ((high - low) / (array[high] - array[low]) * (key - array[low]));

            if (array[pos] == key) {
                return pos;
            }

            if (array[pos] < key)
                low = pos + 1;
            else if (array[pos] > key)
                high = pos - 1;

        }
        return -1;
    }
}
