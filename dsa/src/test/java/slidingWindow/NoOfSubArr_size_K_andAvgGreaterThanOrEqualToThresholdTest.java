package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given an array of integers arr and two integers k and threshold.
 * Return the number of subarrays of size k and average greater than or equal to
 * a threshold.
 */
public class NoOfSubArr_size_K_andAvgGreaterThanOrEqualToThresholdTest {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        // Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
        // Output: 3
        // Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6
        // respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
        int count = 0;
        int windowSum = 0;
        int target = k * threshold;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i >= k - 1) {
                if (windowSum >= target) {
                    count++;
                }
                windowSum -= arr[i - k + 1];
            }
        }

        return count;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, numOfSubarrays(new int[] { 2, 2, 2, 2, 5, 5, 5, 8 }, 3, 4));
    }
}
