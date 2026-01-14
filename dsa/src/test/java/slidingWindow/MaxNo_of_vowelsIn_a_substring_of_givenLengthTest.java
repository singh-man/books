package slidingWindow;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given a string s and an integer k.
 * 
 * Return the maximum number of vowel letters in any substring of s with length k.
 * 
 * Vowel letters in English are (a, e, i, o, u).
 */
public class MaxNo_of_vowelsIn_a_substring_of_givenLengthTest {

    // Input: s = "abciiidef", k = 3
    // Output: 3
    // Explanation: The substring "iii" contains 3 vowel letters.
    public int maxVowels(String s, int k) {
        var vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int v = 0;
        int ans = 0;
        int n = s.length();

        // First window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                v++;
            }
        }
        ans = v;

        // Slide the window
        for (int i = k; i < n; i++) {
            if (vowels.contains(s.charAt(i - k))) {
                v--;
            }
            if (vowels.contains(s.charAt(i))) {
                v++;
            }
            ans = Math.max(ans, v);
        }

        return ans;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, maxVowels("abciiidef", 3));
    }
}
