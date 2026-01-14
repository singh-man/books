package slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LenTheLongestSubstring_withNoVowelsTest {

    // Input: s = "codeforintelligents"
    // Output: 3
    // Explanation: 'nts' is the longest substring that doesn't contain any vowels.
    public int getLongestSubstring(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder result = new StringBuilder();
        StringBuilder maxResult = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!vowels.contains(c)) {
                result.append(c);
                System.out.println(result); // optional, prints current substring
                if (result.length() > maxResult.length()) {
                    maxResult.setLength(0);
                    maxResult.append(result);
                }
            } else {
                result.setLength(0);
            }
        }

        return maxResult.length();
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, getLongestSubstring("codeforintelligents"));
    }
}