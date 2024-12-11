package search;

import sorts.common.SearchAlgorithm;

public class LinearSearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }
}
