package cyclicrotation;

import ciclicrotation.CyclicRotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("CyclicRotation should")
class CyclicRotationTest {

    private final CyclicRotation cyclicRotation = new CyclicRotation();

    @Test
    @DisplayName("return the array with zeros if shift numbers is more then `100` or less then `0`")
    void returnArrWithZerosIfShiftsNumberViolateRestriction() {
        int[] actualWithNegative = cyclicRotation.solution(new int[]{2, 8, 3}, -2);
        int[] actualWitPositive = cyclicRotation.solution(new int[]{2, 7, 3}, 102);

        assertArrayEquals(new int[]{0, 0, 0}, actualWithNegative);
        assertArrayEquals(new int[]{0, 0, 0}, actualWitPositive);
    }

    @Test
    @DisplayName("return the array with zeros if target arrays elements is more" +
            " then `1000` or less then `-1000`")
    void returnArrWithZerosIfArrayElementsViolateRestriction() {
        int[] actualWithNegative = cyclicRotation.solution(new int[]{2, 8, -1001}, 2);
        int[] actualWitPositive = cyclicRotation.solution(new int[]{1001, 7, 3}, 2);

        assertArrayEquals(new int[]{0, 0, 0}, actualWithNegative);
        assertArrayEquals(new int[]{0, 0, 0}, actualWitPositive);
    }

    @Test
    @DisplayName("return cyclic rotated array")
    void rotateArray() {
        int[] actualWithNegative = cyclicRotation.solution(new int[]{1, 2, 3}, 3);
        int[] actualWitPositive = cyclicRotation.solution(new int[]{100, 200, -1}, 2);

        assertArrayEquals(new int[]{1, 2, 3}, actualWithNegative);
        assertArrayEquals(new int[]{200, -1, 100}, actualWitPositive);
    }
}