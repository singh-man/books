package slidingWindow;

/**
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestTurbulentSubArrayTest {

    // Input: arr = [9,4,2,10,7,8,8,1,9]
    // Output: 5
    // Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < n; i++) {
            int c = Integer.compare(arr[i - 1], arr[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == n - 1 || c * Integer.compare(arr[i], arr[i + 1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }

    @Test
    public void test() {
        int[] arr = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
        Assertions.assertEquals(5, maxTurbulenceSize(arr));
    }
}
