package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMinSumSubArr_of_size_K_Test {

    // Input: arr = [10, 4, 2, 5, 6, 3, 8, 1], k = 3
    // Output: 11
    public int getMinSum(int[] arr, int k) {
        int currSum = 0;
        int minSum = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (i - start + 1 == k) {
                minSum = Math.min(minSum, currSum);
                currSum -= arr[start];
                start++;
            }
        }

        return minSum;
    }

    @Test
    public void test() {
        int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
        int k = 3;
        Assertions.assertEquals(11, getMinSum(arr, k));
    }
}
