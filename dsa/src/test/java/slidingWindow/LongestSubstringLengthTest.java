package slidingWindow;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringLengthTest {

    public static int findLengthOfLongestRepeatingCharacters(String s) {
        if (s.length() == 0) return s.length();

        int left = 0, right = 0;
        int longest = 0;
        int n = s.length();
        var window = new HashSet<Character>();
        while (right < n) {
            if (!window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, right - left);
        }

        return longest;
    }

    @Test
    public void test() {
        Assertions.assertEquals(5, findLengthOfLongestRepeatingCharacters("ABCDBEA"));
    }
}
