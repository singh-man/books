package slidingWindow;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The frequency of an element is the number of times it occurs in an array.
 * 
 * You are given an integer array nums and an integer k. In one operation, you
 * can choose an index of nums and increment the element at that index by 1.
 * 
 * Return the maximum possible frequency of an element after performing at most
 * k operations.
 */
public class FrequencyOfTheMostFrequentElementTest {
    
    // Input: nums = [1,2,4], k = 5
    // Output: 3
    // Explanation: Increment the first element three times and the second element
    // two times to make nums = [4,4,4].
    // 4 has a frequency of 3.
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxFreq = 1;
        int freq = 1;
        int left = 0;
        long ops = k; // long to avoid overflow

        for (int right = 1; right < n; right++) {
            ops -= (long) (nums[right] - nums[right - 1]) * freq;
            freq++;

            if (ops >= 0) {
                maxFreq = Math.max(maxFreq, freq);
            } else {
                while (ops < 0) {
                    ops += nums[right] - nums[left];
                    left++;
                    freq--;
                }
            }
        }

        return maxFreq;
    }

    @Test
    public void test() {
        int[] nums = { 1, 2, 4 };
        int k = 5;
        Assertions.assertEquals(3, maxFrequency(nums, k));
    }
}
