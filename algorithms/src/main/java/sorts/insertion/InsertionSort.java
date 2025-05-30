package sorts.insertion;

import common.SortAlgorithm;

public class InsertionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int length = unsorted.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                T element = unsorted[j];
                T minusOneElement = unsorted[j - 1];

                if (element.compareTo(minusOneElement) <= 0) {
                    unsorted[j - 1] = element;
                    unsorted[j] = minusOneElement;
                } else {
                    break;
                }
            }
        }
        return unsorted;
    }
}
