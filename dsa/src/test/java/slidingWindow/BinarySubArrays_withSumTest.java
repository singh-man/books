package slidingWindow;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given binary array nums and an integer goal, return the number of non-empty
 * subarrays with a sum goal.
 * A subarray is a contiguous part of the array.
 */
public class BinarySubArrays_withSumTest {

    // Input: nums = [1,0,1,0,1], goal = 2
    // Output: 4
    // Explanation: The 4 subarrays are bolded and underlined below:
    // [1,0,1,0,1]
    // [1,0,1,0,1]
    // [1,0,1,0,1]
    // [1,0,1,0,1]
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cumSum = 0;
        int result = 0;
        var hashMap = new HashMap<Integer, Integer>();
        hashMap.put(0, 1); // prefix sum 0 occurs once

        for (int x : nums) {
            cumSum += x;
            int val = cumSum - goal;

            if (hashMap.containsKey(val)) {
                result += hashMap.get(val);
            }

            hashMap.put(cumSum, hashMap.getOrDefault(cumSum, 0) + 1);
        }

        return result;
    }

    @Test
    public void test() {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        Assertions.assertEquals(4, numSubarraysWithSum(nums, goal));
    }
}
