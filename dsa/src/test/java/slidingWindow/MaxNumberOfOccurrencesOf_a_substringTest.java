package slidingWindow;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given a string s, return the maximum number of occurrences of any substring
 * under the following rules:
 * 
 * - The number of unique characters in the substring must be less than or equal
 * to maxLetters.
 * - The substring size must be between minSize and maxSize inclusive.
 */
public class MaxNumberOfOccurrencesOf_a_substringTest {

    // Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
    // Output: 2
    // Explanation: Substring "aab" has 2 ocurrences in the original string.
    // It satisfies the conditions, 2 unique letters and size 3 (between minSize and
    // maxSize).
    private int distinctCount(String sub) {
        boolean[] seen = new boolean[128];
        int unique = 0;
        for (char c : sub.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                unique++;
            }
        }
        return unique;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        var count = new HashMap<String, Integer>();
        int res = 0;
        int n = s.length();

        for (int i = 0; i <= n - minSize; i++) {
            String sub = s.substring(i, i + minSize);

            // Count distinct characters in substring
            if (distinctCount(sub) <= maxLetters) {
                count.put(sub, count.getOrDefault(sub, 0) + 1);
                res = Math.max(res, count.get(sub));
            }
        }

        return res;
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, maxFreq("aababcaab", 2, 3, 4));
    }
}
