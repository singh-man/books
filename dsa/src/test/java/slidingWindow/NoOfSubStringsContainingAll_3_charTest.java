package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 */
public class NoOfSubStringsContainingAll_3_charTest {

    // Input: s = "abcabc"
    // Output: 10
    // Explanation: The substrings containing at least one occurrence of the
    // characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
    // "bcabc", "cab", "cabc" and "abc" (again)
    public int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0;
        int n = s.length();

        int[] map = new int[3]; // for 'a','b','c'

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            map[c - 'a']++;

            while (map[0] > 0 && map[1] > 0 && map[2] > 0) {
                char leftChar = s.charAt(left);
                map[leftChar - 'a']--;
                left++;
            }

            count += left;
        }

        return count;
    }

    @Test
    public void test() {
        Assertions.assertEquals(10, numberOfSubstrings("abcabc"));
    }
}
