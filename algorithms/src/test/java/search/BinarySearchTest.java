package search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("`BinarySearch` should ")
public class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @SuppressWarnings({"rawtypes", "unchecked"})
    @ParameterizedTest
    @MethodSource("searchTestData")
    @DisplayName("sort various input arrays")
    void testLinearSearch(Comparable[] array, Comparable target, int expectedIndex) {
        int actualIndex = binarySearch.find(array, target);
        assertEquals(expectedIndex, actualIndex);
    }

    public static Stream<Arguments> searchTestData() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 3, 2),
                Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 5, 4),
                Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 1, 0),   // Target is the first element
                Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 6, -1),  // Target is not in the array
                Arguments.of(new Integer[]{10, 20, 30, 40, 50}, 30, 2), // Test with larger numbers
                Arguments.of(new String[]{"apple", "banana", "cherry", "date"}, "cherry", 2),  // Test with strings
                Arguments.of(new String[]{"apple", "banana", "cherry", "date"}, "grape", -1)   // String target not found
        );
    }
}