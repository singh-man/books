package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * You are given an array of positive integers nums and want to erase a subarray
 * containing unique elements. The score you get by erasing the subarray is
 * equal to the sum of its elements.
 * 
 * Return the maximum score you can get by erasing exactly one subarray.
 * 
 * An array b is called to be a subarray if it forms a contiguous subsequence of
 * a that is if it is equal to a[l], a[l+1],…, a[r] for some (l,r).
 */
public class MaxErasureValueTest {

    // Input: nums = [4,2,4,5,6]
    // Output: 17
    // Explanation: The optimal subarray here is [2,4,5,6].
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int finalSum = 0;
        int sum = 0;
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                while (l <= index) {
                    map.remove(nums[l]);
                    sum -= nums[l];
                    l++;
                }
            }

            map.put(nums[i], i);
            sum += nums[i];
            finalSum = Math.max(finalSum, sum);
        }

        return finalSum;
    }

    @Test
    public void test() {
        int[] nums = { 4, 2, 4, 5, 6 };
        Assertions.assertEquals(17, maximumUniqueSubarray(nums));
    }
}
