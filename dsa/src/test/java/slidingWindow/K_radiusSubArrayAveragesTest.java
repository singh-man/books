package slidingWindow;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Build and return an array avgs of length n where avgs[i] is
 * the k-radius average for the subarray centered at index i.
 */
public class K_radiusSubArrayAveragesTest {

    // Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
    // Output: [-1,-1,-1,5,4,4,-1,-1,-1]
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if (k == 0)
            return nums.clone(); // return a copy of nums

        int[] ans = new int[n];
        Arrays.fill(ans, -1); // initialize all elements to -1
        long[] prefSum = new long[n]; // use long to avoid integer overflow

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefSum[i] = (i == 0) ? nums[i] : prefSum[i - 1] + nums[i];
        }

        // Calculate K-radius averages
        for (int i = k; i < n - k; i++) {
            long total = prefSum[i + k] - ((i - k - 1 >= 0) ? prefSum[i - k - 1] : 0);
            ans[i] = (int) (total / (2 * k + 1));
        }

        return ans;
    }

    @Test
    public void test() {
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        Assertions.assertArrayEquals(new int[] { -1, -1, -1, 5, 4, 4, -1, -1, -1 }, getAverages(nums, k));
    }
}
