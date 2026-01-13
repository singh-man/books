package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiffBtw_MaxAndMin_Avg_of_all_K_lengthContinousSubArrTest {

    // Input: arr[ ] = {3, 8, 9, 15},
    // K = 2
    // Output: 6.5

    // All subarrays of length 2 are {3, 8}, {8, 9}, {9, 15} and their averages are
    // (3+8)/2 = 5.5, (8+9)/2 = 8.5, and (9+15)/2 = 12.0 respectively.
    // Therefore, the difference between the maximum(=12.0) and minimum(=5.5) is
    // 12.0 - 5.5 = 6.5.
    public double getMinMaxDiff(int[] arr, int k) {
        int n = arr.length;

        if (k > n) {
            return -1;
        }

        double minAvg = Double.POSITIVE_INFINITY;
        double maxAvg = Double.NEGATIVE_INFINITY;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        for (int i = k; i < n; i++) {
            double currentAvg = (double) windowSum / k;
            minAvg = Math.min(minAvg, currentAvg);
            maxAvg = Math.max(maxAvg, currentAvg);

            windowSum -= arr[i - k];
            windowSum += arr[i];
        }

        double lastAvg = (double) windowSum / k;
        minAvg = Math.min(minAvg, lastAvg);
        maxAvg = Math.max(maxAvg, lastAvg);

        return maxAvg - minAvg;
    }

    @Test
    public void test() {
        int[] arr = { 3, 8, 9, 15 };
        int k = 2;
        // Expected Output: 6.5
        Assertions.assertEquals(6.5, getMinMaxDiff(arr, k));
    }
}