package slidingWindow;

import org.junit.jupiter.api.Assertions;

/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that 
 * appears in both arrays.
 */
import org.junit.jupiter.api.Test;

public class MaxLength_of_repeatedSubArrayTest {

    // Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    // Output: 3
    // Explanation: The repeated subarray with maximum length is [3,2,1].
    public int findLength(int[] nums1, int[] nums2) {
        // Convert nums2 to a string
        StringBuilder sb2 = new StringBuilder();
        for (int num : nums2) {
            sb2.append((char) num);
        }
        String nums2Str = sb2.toString();

        StringBuilder maxStr = new StringBuilder();
        int res = 0;

        for (int num : nums1) {
            maxStr.append((char) num);

            if (nums2Str.contains(maxStr.toString())) {
                res = Math.max(res, maxStr.length());
            } else {
                // remove first character
                maxStr.deleteCharAt(0);
            }
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums1 = { 1, 2, 3, 2, 1 };
        int[] nums2 = { 3, 2, 1, 4, 7 };
        Assertions.assertEquals(3, findLength(nums1, nums2));
    }
}
