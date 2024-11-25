package arrlistlen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("ArrListLen should")
class ArrListLenTest {

    private final ArrListLen arrListLen = new ArrListLen();

    @Test
    @DisplayName("return `4` because the list contains 4 nodes")
    void return4Nodes() {
        int[] arr = {1, 4, -1, 3, 2};
        assertEquals(4, arrListLen.solution(arr));
    }

    @Test
    @DisplayName("return `1` because the list contains 1 nodes(end of list)")
    void returnSingleNodes() {
        int[] arr = {-1};
        assertEquals(1, arrListLen.solution(arr));
    }

    @Test
    @DisplayName("return `2` because the list contains 2 nodes")
    public void testListWithDirectEnd() {
        int[] A = {1, -1};
        assertEquals(2, arrListLen.solution(A));
    }

    @Test
    @DisplayName("throw `ArrayIndexOutOfBoundsException` when the index" +
            " is greater than the actual capacity")
    void throwException() {
        int[] arr = {1, 4, -1};
        assertThrows(ArrayIndexOutOfBoundsException.class,
                     () -> arrListLen.solution(arr));
    }
}