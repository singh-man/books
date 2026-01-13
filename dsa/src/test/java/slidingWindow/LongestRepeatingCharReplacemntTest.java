package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other
 * uppercase English character.
 * You can perform this operation at most k times.
 */
public class LongestRepeatingCharReplacemntTest {

    // Input: s = "ABAB", k = 2
    // Output: 4
    // Explanation: Replace the two 'A's with two 'B's or vice versa.
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // frequency of each uppercase letter
        int maxRepeatLetterCount = 0;
        int windowStart = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'A']++; // assumes uppercase letters

            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, freq[c - 'A']);

            if (i - windowStart + 1 - maxRepeatLetterCount > k) {
                freq[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }

    @Test
    public void test() {
        Assertions.assertEquals(4, characterReplacement("ABAB", 2));
    }
}
