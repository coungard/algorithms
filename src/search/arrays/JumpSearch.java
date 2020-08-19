package search.arrays;

public class JumpSearch {

    public static int step;

    /**
     * Time complexity = O(sqrt(n))
     *
     * @param array array, where we searching
     * @param key target number
     * @return index, where number found
     */
    public static int search(int[] array, int key) {
        step = 0;

        int len = array.length;
        int jumpStep = (int) Math.sqrt(array.length);
        int previousStep = 0;

        while (array[Math.min(jumpStep, len) - 1] < key) {
            step++;
            previousStep = jumpStep;
            jumpStep += (int) (Math.sqrt(len));
            if (previousStep >= len)
                return -1;
        }

        while (array[previousStep] < key) {
            step++;
            previousStep++;
            if (previousStep == Math.min(jumpStep, len))
                return -1;
        }

        if (array[previousStep] == key)
            return previousStep;

        return -1;
    }
}
