package slidingWindow;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1’s permutations is the substring of s2.
 */
public class Permutation_in_stringTest {

    // Input: s1 = "ab", s2 = "eidbaooo"
    // Output: true
    // Explanation: s2 contains one permutation of s1 ("ba").
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] numbers = new int[26];
        int[] numbers2 = new int[26];

        // Frequency of characters in s1
        for (char c : s1.toCharArray()) {
            numbers[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            numbers2[s2.charAt(i) - 'a']++;

            if (i >= s1.length() - 1) {
                if (Arrays.equals(numbers, numbers2)) {
                    return true;
                }
                // Slide the window
                numbers2[s2.charAt(i - s1.length() + 1) - 'a']--;
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assertions.assertTrue(checkInclusion("ab", "eidbaooo"));
    }
}
