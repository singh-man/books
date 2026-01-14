package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindAllAnagramsInStringTest {

    // Input: s = "cbaebabacd", p = "abc"
    // Output: [0,6]
    // Explanation:
    // The substring with start index = 0 is "cba", which is an anagram of "abc".
    // The substring with start index = 6 is "bac", which is an anagram of "abc".
    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        int[] count = new int[26];
        var result = new ArrayList<Integer>();
        int start = 0;

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;

            if (i - start + 1 > p.length()) {
                count[s.charAt(start) - 'a']--;
                start++;
            }

            if (Arrays.equals(count, target)) {
                result.add(start);
            }
        }

        return result;
    }

    @Test
    public void test() {
        Assertions.assertEquals(List.of(0, 6), findAnagrams("cbaebabacd", "abc"));
    }
}
