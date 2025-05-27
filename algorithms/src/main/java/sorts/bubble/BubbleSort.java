package sorts.bubble;

import sorts.common.SortAlgorithm;

public class BubbleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int length = unsorted.length;
        for (int i = 1; i < length; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i; j++) {
                if (isGreater(unsorted, j)) {
                    swap(j, j + 1, unsorted);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return unsorted;
    }

    private static <T extends Comparable<T>> boolean isGreater(T[] unsorted, int j) {
        return unsorted[j].compareTo(unsorted[j + 1]) > 0;
    }

    private static <T extends Comparable<T>> void swap(int firstIndex, int secondIndex,
                                                       T[] unsorted) {
        T tempValue = unsorted[firstIndex];
        unsorted[firstIndex] = unsorted[secondIndex];
        unsorted[secondIndex] = tempValue;
    }
}
