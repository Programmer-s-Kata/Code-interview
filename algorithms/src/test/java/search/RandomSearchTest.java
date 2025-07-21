package search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RandomSearchTest {

    @ParameterizedTest
    @MethodSource("providePresentElements")
    <T extends Comparable<T>> void whenElementPresentThenReturnValidIndex(T[] array, T target) {
        RandomSearch search = new RandomSearch();
        int index = search.find(array, target);

        assertNotEquals(-1, index, "Element should be found");
        assertEquals(target, array[index], "Returned index should contain target");
    }

    @ParameterizedTest
    @MethodSource("provideAbsentElements")
    <T extends Comparable<T>> void whenElementAbsentThenReturnMinusOne(T[] array, T target) {
        RandomSearch search = new RandomSearch();
        int index = search.find(array, target);
        assertEquals(-1, index, "Should return -1 when element is missing");
    }

    @Test
    void whenArrayEmptyThenReturnMinusOne() {
        RandomSearch search = new RandomSearch();
        Integer[] array = {};
        int index = search.find(array, 10);
        assertEquals(-1, index, "Should return -1 for empty array");
    }

    @Test
    void whenMultipleOccurrencesThenReturnAnyValidIndex() {
        RandomSearch search = new RandomSearch();
        Integer[] array = {1, 3, 5, 3, 7};
        int target = 3;
        int index = search.find(array, target);

        assertTrue(index == 1 || index == 3, "Index should point to target element");
        assertEquals(target, array[index], "Returned index should contain target");
    }

    private static Stream<Arguments> providePresentElements() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4}, 2),
                Arguments.of(new String[]{"a", "b", "c"}, "b"),
                Arguments.of(new Double[]{1.1, 2.2, 3.3}, 3.3),
                Arguments.of(new Integer[]{5}, 5)
        );
    }

    private static Stream<Arguments> provideAbsentElements() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4}, 5),
                Arguments.of(new String[]{"a", "b", "c"}, "d"),
                Arguments.of(new Double[]{1.1, 2.2, 3.3}, 4.4)
        );
    }
}