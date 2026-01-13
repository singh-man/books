package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinSizeSubArrSumTest {

    // input: target = 7, nums = [2,3,1,2,4,3]
    // Output: 2
    // Explanation: The subarray [4,3] has the minimal length under the problem constraint
    public static int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int start = 0;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            while (currSum >= target) {
                minCount = Math.min(minCount, i - start + 1);
                currSum -= nums[start];
                start++;
            }
        }

        return (minCount == Integer.MAX_VALUE) ? 0 : minCount;
    }

    @Test
    public void test() {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        Assertions.assertEquals(2, minSubArrayLen(target, nums));
    }
}
