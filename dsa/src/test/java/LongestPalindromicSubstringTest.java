import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstringTest {
    // This function prints the longest palindrome substring (LPS) of str[]. It also returns the length of the longest
    // palindrome
    int longestPalSubstring(String str) {
        int n = str.length();
        if (n < 2) return n; // if string is empty then size will be 0.
        // if n==1 then, answer will be 1(single
        // character will always palindrome)

        int maxLength = 1, start = 0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i)) //increment 'high'
                high++;

            while (low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
                low--;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }
        System.out.print("Longest palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength));
        return maxLength;
    }

    // Driver program to test above function
    @Test
    public void testOptimize() {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstring(str));
    }

    boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) == str.charAt(end)) {
            return isPalindrome(str, start + 1, end - 1);
        } else return false;
    }

    // Function to print a subString str[low..high]
    void printSubStr(String str, int low, int high) {
        for (int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }

    // This function prints the longest palindrome subString
    // It also returns the length of the longest palindrome
    int longestPalSubstrBruteForce(String str) {
        // get length of input String
        int n = str.length();

        // All subStrings of length 1 are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {

                boolean isPalindrome = isPalindrome(str, i, j);

                // Palindrome
                if (isPalindrome && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.println("Longest palindrome subString is: " + str.substring(start, start + maxLength));
//        printSubStr(str, start, start + maxLength - 1);
        // return length of LPS
        return maxLength;
    }

    @Test
    public void test() {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstrBruteForce(str));
    }

    @Test
    public void testPalindrome() {
        String str = "aba";
        Assertions.assertTrue(isPalindrome(str, 0, str.length() - 1));
        str = "abaaba";
        Assertions.assertTrue(isPalindrome(str, 0, str.length() - 1));
        str = "abcaba";
        Assertions.assertFalse(isPalindrome(str, 0, str.length() - 1));
    }
}
