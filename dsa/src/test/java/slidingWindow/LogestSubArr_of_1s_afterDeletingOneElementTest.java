package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given binary array nums, you should delete one element from it.
 * 
 * Return the size of the longest non-empty subarray containing only 1’s in the
 * resulting array. Return 0 if there is no such subarray.
 */
public class LogestSubArr_of_1s_afterDeletingOneElementTest {
    
    // Input: nums = [1,1,0,1]
    // Output: 3
    // Explanation: After deleting the number in position 2, [1,1,1] contains 3
    // numbers with value of 1's.
    public int longestSubarray(int[] nums) {
        int windowStart = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLength = 0;

        // Initialize counts for all numbers in nums
        for (int num : nums) {
            countMap.put(num, 0);
        }

        // Edge case: if there are no zeros, we must delete one element
        if (!countMap.containsKey(0)) {
            return nums.length - 1;
        }

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int endNum = nums[windowEnd];
            countMap.put(endNum, countMap.get(endNum) + 1);

            // More than one zero in window: shrink from left
            while (countMap.get(0) > 1) {
                int startNum = nums[windowStart];
                countMap.put(startNum, countMap.get(startNum) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength;
    }

    @Test
    public void test() {
        int[] nums = { 1, 1, 0, 1 };
        Assertions.assertEquals(3, longestSubarray(nums));
    }
}
