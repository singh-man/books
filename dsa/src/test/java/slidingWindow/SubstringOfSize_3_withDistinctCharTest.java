package slidingWindow;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A string is good if there are no repeated characters.
 * 
 * Given a string s, return the number of good substrings of length three in s​​​​​.
 * 
 * If there are multiple occurrences of the same substring, every occurrence
 * should be counted.
 * 
 * A substring is a contiguous sequence of characters in a string.
 */
public class SubstringOfSize_3_withDistinctCharTest {

    // Input: s = "xyzzaz"
    // Output: 1
    // Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
    // The only good substring of length 3 is "xyz".
    public int countGoodSubstrings(String s) {
        int k = 3;
        if (k > s.length())
            return 0;

        var freq = new HashMap<Character, Integer>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            if (i >= k - 1) {
                if (freq.size() == k) {
                    count++;
                }

                char left = s.charAt(start);
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0) {
                    freq.remove(left);
                }
                start++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        Assertions.assertEquals(1, countGoodSubstrings("xyzzaz"));
    }
}