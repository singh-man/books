package slidingWindow;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given an array of integers arr and an integer target.
 * 
 * You have to find two non-overlapping subarrays of arr each with a sum equal
 * target. There can be multiple answers so you have to find an answer where the
 * sum of the lengths of the two subarrays is minimum.
 * 
 * Return the minimum sum of the lengths of the two required subarrays, or
 * return -1 if you cannot find such two subarrays.
 */
public class Find_2_nonOverlappingSubArr_eachWithTargetSumTest {

    // Input: arr = [3,2,2,4,3], target = 3
    // Output: 2
    // Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their
    // lengths is 2
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;
        int[] bestAt = new int[n];
        Arrays.fill(bestAt, INF);

        int best = INF;
        int currSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > target && left <= right) {
                currSum -= arr[left];
                left++;
            }

            if (currSum == target) {
                int length = right - left + 1;
                if (left > 0) {
                    best = Math.min(best, bestAt[left - 1] + length);
                }
                bestAt[right] = (right > 0) ? Math.min(bestAt[right - 1], length) : length;
            } else {
                bestAt[right] = (right > 0) ? bestAt[right - 1] : INF;
            }
        }

        return best == INF ? -1 : best;
    }

    @Test
    public void test() {
        int[] arr = { 3, 2, 2, 4, 3 };
        int target = 3;
        Assertions.assertEquals(2, minSumOfLengths(arr, target));
    }
}
