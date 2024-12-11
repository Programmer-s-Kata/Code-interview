package search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

@DisplayName("`LinearSearch` should ")
public class LinearSearchTest {

    private final LinearSearch linearSearch = new LinearSearch();

    @SuppressWarnings({"rawtypes", "unchecked"})
    @ParameterizedTest
    @MethodSource("searchTestData")
    @DisplayName("sort various input arrays")
    void testLinearSearch(Comparable[] array, Comparable target, int expectedIndex) {
        int actualIndex = linearSearch.find(array, target);
        assertEquals(expectedIndex, actualIndex);
    }

    static Stream<Arguments> searchTestData() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 3, 2),
                Arguments.of(new Integer[]{10, 20, 30, 40, 50}, 40, 3),
                Arguments.of(new String[]{"a", "b", "c", "d", "e"}, "c", 2),
                Arguments.of(new Integer[]{10, 20, 30}, 100, -1),
                Arguments.of(new String[]{"apple", "banana", "cherry"}, "banana", 1)
        );
    }
}