package twosum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("TwoSum should")
class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    @DisplayName("return indices [0,1] when numbers at these positions sum to target")
    void returnCorrectIndicesForValidSum() {
        int[] nums = {2, 7, 11, 15};
        assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(nums, 9));
    }

    @Test
    @DisplayName("handle duplicate values and return correct indices")
    void handleDuplicateValuesCorrectly() {
        int[] nums = {3, 3};
        assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(nums, 6));
    }

    @Test
    @DisplayName("return [-1,-1] when no two numbers sum to target")
    void returnNotFoundWhenNoSolutionExists() {
        int[] nums = {1, 2, 3};
        assertArrayEquals(new int[]{-1, -1}, twoSum.twoSum(nums, 7));
    }

    @Test
    @DisplayName("throw IllegalArgumentException when array length is below minimum")
    void rejectArraysShorterThanMinimum() {
        int[] nums = {1};
        assertThrows(IllegalArgumentException.class,
                     () -> twoSum.twoSum(nums, 1));
    }

    @Test
    @DisplayName("throw IllegalArgumentException when array length exceeds maximum")
    void rejectArraysLongerThanMaximum() {
        int[] nums = new int[10_001];
        assertThrows(IllegalArgumentException.class,
                     () -> twoSum.twoSum(nums, 0));
    }

    @Test
    @DisplayName("throw IllegalArgumentException when target value is too small")
    void rejectTargetValuesBelowMinimum() {
        int[] nums = {1, 2};
        assertThrows(IllegalArgumentException.class,
                     () -> twoSum.twoSum(nums, -1_000_001));
    }

    @Test
    @DisplayName("throw IllegalArgumentException when target value is too large")
    void rejectTargetValuesAboveMaximum() {
        int[] nums = {1, 2};
        assertThrows(IllegalArgumentException.class,
                     () -> twoSum.twoSum(nums, 1_000_001));
    }

    @Test
    @DisplayName("throw IllegalArgumentException when array contains out-of-bounds values")
    void rejectArraysWithInvalidElements() {
        int[] nums = {1, 1_000_001};
        assertThrows(IllegalArgumentException.class,
                     () -> twoSum.twoSum(nums, 0));
    }
}