package search;

import sorts.common.SearchAlgorithm;

public class BinarySearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int median = low + ((high - low) / 2);  // Correctly calculate the midpoint
            int result = array[median].compareTo(target);  // Compare median element to target

            if (result < 0) {
                // If the target is greater than the median, ignore the low half
                low = median + 1;
            } else if (result > 0) {
                // If the target is less than the median, ignore the high half
                high = median - 1;
            } else {
                // If we found the target, return the index
                return median;
            }
        }

        // If target is not found, return -1
        return -1;
    }
}