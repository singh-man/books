package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * You are given an integer array of nums consisting of n elements and an
 * integer k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10–5 will be accepted.
 */
public class MaxAvgSubArrayTest {

    // Input: nums = [1, 12, -5, -6, 50, 3], k = 4
    // Output: 12.75000
    // Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    public double findMaxAverage(int[] nums, int k) {
        int st = 0;
        double maxSum = Double.NEGATIVE_INFINITY;
        double winSum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            winSum += nums[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, winSum);
                winSum -= nums[st];
                st++;
            }
        }

        return maxSum / k;
    }

    @Test
    public void test() {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        Assertions.assertEquals(12.75, findMaxAverage(nums, k));
    }

}
