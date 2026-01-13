package slidingWindow;

/**
 * Given binary array nums and an integer k, return the maximum number of consecutive 1’s 
 * in the array if you can flip at most k 0’s.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxConsecutiveOnes_III_Test {

    // Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    // Output: 6
    // Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    // Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, n = nums.length;
        int maxConsecutive = 0;

        while (end < n) {
            if (nums[end] == 0) {
                if (k > 0) {
                    k--;
                } else {
                    maxConsecutive = Math.max(maxConsecutive, end - start);
                    if (nums[start] == 0) {
                        k++;
                    }
                    start++;
                    continue; // stay at same end to process new window
                }
            }
            end++;
        }

        // Check last window
        maxConsecutive = Math.max(maxConsecutive, end - start);

        return maxConsecutive;
    }

    @Test
    public void test() {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        Assertions.assertEquals(6, longestOnes(nums, k));
    }
}
