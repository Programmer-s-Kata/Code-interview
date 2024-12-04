package sorts.common;

/**
 * The general interface for all sorting algorithms.
 */
public interface SortAlgorithm {

    /**
     * Declares a sorting method.
     *
     * @param unsorted
     *         an array should be sorted
     * @param <T>
     *         a type of objects that this object may be compared to
     * @return the sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);

}
