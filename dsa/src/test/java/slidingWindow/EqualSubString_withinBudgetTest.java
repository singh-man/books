package slidingWindow;

/**
 * You are also given an integer maxCost.  Return the maximum length of a substring of s that can be 
 * changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost.
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualSubString_withinBudgetTest {

    // Input: s = "abcd", t = "bcdf", maxCost = 3
    // Output: 3
    // Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum
    // length is 3.
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];

        // Calculate absolute differences
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int sum = 0;
        int low = 0;
        int length = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];

            // Shrink window if sum exceeds maxCost
            while (low <= i && sum > maxCost) {
                sum -= diff[low];
                low++;
            }

            if (sum <= maxCost) {
                length = Math.max(length, i - low + 1);
            }
        }

        return length;
    }

    @Test
    public void test() {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        Assertions.assertEquals(3, equalSubstring(s, t, maxCost));
    }
}
