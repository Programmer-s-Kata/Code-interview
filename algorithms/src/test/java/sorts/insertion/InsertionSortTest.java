package sorts.insertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("`InsertionSort` should ")
class InsertionSortTest {

    private final InsertionSort insertionSort = new InsertionSort();

    @ParameterizedTest
    @MethodSource("provideArraysAndNames")
    @DisplayName("test sorting with various input arrays")
    void testSortWithDifferentArraysAndNames(Integer[] input, Integer[] expected) {
        Integer[] sorted = insertionSort.sort(input);
        assertArrayEquals(expected, sorted);
    }

    private static Stream<Arguments> provideArraysAndNames() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 2, 1, 0, -101},
                             new Integer[]{-101, 0, 1, 2, 3}),
                Arguments.of(new Integer[]{-101, 0, 1, 2, 3},
                             new Integer[]{-101, 0, 1, 2, 3}),
                Arguments.of(new Integer[]{5, 3, 8, 3, 1, 5},
                             new Integer[]{1, 3, 3, 5, 5, 8}),
                Arguments.of(new Integer[]{42}, new Integer[]{42}));
    }
}