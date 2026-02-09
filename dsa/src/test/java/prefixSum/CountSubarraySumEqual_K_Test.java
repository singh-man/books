package prefixSum;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * Input : arr[] = [10, 2, -2, -20, 10], k = -10
 * Output : 3
 * Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum equal to -10.
 * 
 * Input : arr[] = [9, 4, 20, 3, 10, 5], k = 33
 * Output : 2
 * Explanation: Subarrays: arr[0...2], arr[2...4] have sum equal to 33.
 * 
 * Input : arr[] = [1, 3, 5], k = 2
 * Output : 0
 * Explanation: No subarrays with 0 sum.
 */
public class CountSubarraySumEqual_K_Test {

    int cntSubarrays(int[] arr, int k) {

        // HashMap to store prefix sums frequencies
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum so far.
            currSum += arr[i];

            // If currSum is equal to desired sum
            // then a new subarray is found.
            if (currSum == k)
                res++;

            // Check if the difference exists in the prefixSums map.
            if (prefixSums.containsKey(currSum - k))
                res += prefixSums.get(currSum - k);

            // Add currSum to the set of prefix sums.
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = { 10, 2, -2, -20, 10 };
        int k = -10;
        Assertions.assertEquals(3, cntSubarrays(arr, k));
        System.out.println(cntSubarrays(arr, k));
    }
}
