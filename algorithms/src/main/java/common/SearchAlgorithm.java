package common;

public interface SearchAlgorithm {

    <T extends Comparable<T>> int find(T[] array, T target);
}
