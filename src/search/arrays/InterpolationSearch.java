package search.arrays;

public class InterpolationSearch {
    public static int step;

    // 0 + (9 - 0) / (10 - 1) * (6 - 1) 
    public static int search(int[] array, int key) {
        step = 0;
        int low = 0;
        int high = (array.length - 1);

        while ((low <= high) && (key >= array[low]) && (key <= array[high])) {
            step++;

            if (low == high) {
                if (array[high] == key)
                    return high;
                else
                    return -1;
            }

            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = low + (((high - low) / (array[high] - array[low])) * (key - array[low]));

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
