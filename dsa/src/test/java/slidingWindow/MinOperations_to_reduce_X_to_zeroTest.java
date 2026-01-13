package slidingWindow;

/**
 * You are given an integer array nums and an integer x. In one operation, you can either remove 
 * the leftmost or the rightmost element from the array nums and subtract its value from x. 
 * Note that this modifies the array for future operations.
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, 
 * otherwise, return -1.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinOperations_to_reduce_X_to_zeroTest {

    // Input: nums = [1,1,4,2,3], x = 5
    // Output: 2
    // Explanation: The optimal solution is to remove the last two elements to
    // reduce x to zero.
    public int minOperations(int[] nums, int x) {
        int S = 0;
        for (int num : nums) {
            S += num;
        }

        int left = 0, right = 0, curr = 0;
        int ans = -1;
        int n = nums.length;

        while (right < n) {
            curr += nums[right];
            right++;

            while (left < n && curr > S - x) {
                curr -= nums[left];
                left++;
            }

            if (curr == S - x) {
                ans = Math.max(ans, right - left);
            }
        }

        return (ans != -1) ? n - ans : -1;
    }

    @Test
    public void test() {
        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;
        Assertions.assertEquals(2, minOperations(nums, x));
    }
}
