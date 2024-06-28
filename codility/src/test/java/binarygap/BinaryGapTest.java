package binarygap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BinaryGap should")
class BinaryGapTest {

    private final BinaryGap binaryGap = new BinaryGap();

    @Test
    @DisplayName("return zero when the number does not have binary gaps")
    void returnZero() {
        assertEquals(binaryGap.solution(15), 0);
    }

    @Test
    @DisplayName("return zero when number is negative")
    void returnZeroIfNegative() {
        assertEquals(binaryGap.solution(-15), 0);
    }

    @Test
    @DisplayName("return a biggest size ")
    void returnBiggestGapSize() {
        assertEquals(binaryGap.solution(66561), 9);
    }
}