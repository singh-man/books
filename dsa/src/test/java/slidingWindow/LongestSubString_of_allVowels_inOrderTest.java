package slidingWindow;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given a string word consisting of English vowels, return the length of the
 * longest beautiful substring of a word. If no such substring exists, return 0.
 * A substring is a contiguous sequence of characters in a string.
 */
public class LongestSubString_of_allVowels_inOrderTest {

    // Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
    // Output: 13
    // Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of
    // length 13.
    public int longestBeautifulSubstring(String word) {
        int res = 0;
        int i = 0;
        var seen = new HashSet<Character>();

        for (int j = 0; j < word.length(); j++) {
            if (j > 0 && word.charAt(j) < word.charAt(j - 1)) {
                seen.clear();
                i = j;
            }

            seen.add(word.charAt(j));

            if (seen.size() == 5) {
                res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    @Test
    public void test() {
        Assertions.assertEquals(13, longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
