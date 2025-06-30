package search;

import common.SearchAlgorithm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSearch implements SearchAlgorithm {

    private final Random random = new Random();

    @Override
    public <T extends Comparable<T>> int find(T[] array, T target) {
        Set<Integer> visited = new HashSet<>();
        int size = array.length;

        while (visited.size() < size) {
            int randIndex = random.nextInt(size);
            if (array[randIndex].compareTo(target) == 0) {
                return randIndex;
            }
            visited.add(randIndex);
        }
        return -1;
    }
}

