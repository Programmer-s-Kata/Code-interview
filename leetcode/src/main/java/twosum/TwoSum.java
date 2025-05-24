package twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @implNote The implementation with {@code Map}.
 */
public class TwoSum {

    //Constraints
    private static final int MIN_ARR_LENGTH = 2;
    private static final int MAX_ARR_LENGTH = 10_000;
    private static final int MIN_VALUE = -1_000_000;
    private static final int MAX_VALUE = 1_000_000;

    public int[] twoSum(int[] nums, int target) {
        checkLength(nums);
        checkValue(target);
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            checkValue(currentElement);

            int difference = target - currentElement;
            if (numToIndex.containsKey(difference)) {
                return new int[]{numToIndex.get(difference), i};
            }
            numToIndex.put(currentElement, i);

        }
        return new int[]{-1, -1};
    }

    private static void checkLength(int[] nums) {
        if (nums.length < MIN_ARR_LENGTH || nums.length > MAX_ARR_LENGTH) {
            throw new IllegalArgumentException(
                    "Array length should be between " + MIN_ARR_LENGTH + " and " + MAX_ARR_LENGTH);
        }
    }

    private static void checkValue(int target) {
        if (target < MIN_VALUE || target > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Value should be between " + MIN_VALUE + " and " + MAX_VALUE);
        }
    }
}
