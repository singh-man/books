package slidingWindow;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringK_DistinctTest {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Map to store the frequency of each character in the current window
        Map<Character, Integer> charCountMap = new HashMap<>();
        int longestSubstringLength = 0; // variable to store the length of the longest substring
        int left = 0; // left pointer for the sliding window

        // Iterate through the string using the right pointer of the sliding window
        for (int right = 0; right < s.length(); ++right) {
            // Step 1: Update the count of the current character
            char currentChar = s.charAt(right);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

            // Step 2: Shrink the window from the left if count map has more than 'k' distinct characters
            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                // Remove the character from map when count becomes zero
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++; // shrink the window from the left
            }

            // Step 3: Update the longest substring length if the current window is larger
            longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);
        }

        return longestSubstringLength; // Return the length of the longest substring found
    }

    @Test
    public void test() {
        System.out.println(new LongestSubStringK_DistinctTest().lengthOfLongestSubstringKDistinct("aabcabb", 2));
    }
}
