package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given an array of positive integers and a positive number k, find the maximum sum of any 
 * contiguous subarray of size k.
 */
public class ArrayMaxOfSubarrayOfSize_K_Test {

    // Input: [3, 5, 2, 1, 7],  k=2
    // Output: 8
    public static int getMaxSum(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if ((i - start + 1) == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    @Test
    public void test() {
        int[] arr = { 3, 5, 2, 1, 7 };
        int k = 2;
        Assertions.assertEquals(8, getMaxSum(arr, k));
    }

}