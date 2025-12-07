package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Input: arr[] = {3, 8, 9, 15}, K = 2
 * Output: 6.5
 * All subarrays of length 2 are {3, 8}, {8, 9}, {9, 15} and their averages are
 * (3+8)/2 = 5.5, (8+9)/2 = 8.5, and (9+15)/2 = 12.0 respectively.
 * Therefore, the difference between the maximum(=12.0) and minimum(=5.5) is 12.0 - 5.5 = 6.5.
 */
public class MaxMinAvgDiffTest {

    private float test(int[] arr, int k) {

        float minAvg, maxAvg;
        // sum
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += arr[i];
        }
        minAvg = maxAvg = total / 2f;

        for (int i = k; i < arr.length; i++) {
            total = total - arr[i - k] + arr[i];
            minAvg = Math.min(minAvg, total / 2f);
            maxAvg = Math.max(maxAvg, total / 2f);
        }
        return maxAvg - minAvg;
    }

    @Test
    public void test() {
        float diff = new MaxMinAvgDiffTest().test(new int[]{3, 8, 9, 15}, 2);
        System.out.println(diff);
        Assertions.assertEquals(6.5, diff);
    }
}
