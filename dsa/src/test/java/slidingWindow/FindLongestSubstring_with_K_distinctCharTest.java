package slidingWindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindLongestSubstring_with_K_distinctCharTest {

    // Input: s = 'abcbdbdbbdcdabd'
    // k = 2
    // Output: bdbdbbd
    public String getLongest(String s, int k) {
        int high = 0;
        Set<Character> windows = new HashSet<>();
        int[] freq = new int[128];
        int low = 0, end = 0, start = 0;

        while (high < s.length()) {
            char ch = s.charAt(high);
            windows.add(ch);
            freq[ch]++;

            while (windows.size() > k) {
                char left = s.charAt(low);
                freq[left]--;
                if (freq[left] == 0) {
                    windows.remove(left);
                }
                low++;
            }

            if (end - start < high - low) {
                end = high;
                start = low;
            }

            high++;
        }

        return s.substring(start, end + 1);
    }

    @Test
    public void test() {
        Assertions.assertEquals("bdbdbbd", getLongest("abcbdbdbbdcdabd", 2));
    }
}
