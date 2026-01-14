package slidingWindow;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/* Given a word and a text, return the count of occurrences of the anagrams of the word in the text. */
public class CountOccurrencesOfAnagramTest {

    // Input: text = gotxxotgxdogt, word = got
    // Output : 3
    private boolean isAnagram(String s, String word) {
        if (s.length() != word.length())
            return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        for (char c : word.toCharArray())
            freq[c - 'a']--;

        for (int x : freq)
            if (x != 0)
                return false;
        return true;
    }

    public int countAnagram(String text, String word) {
        int w = word.length();
        int count = 0;
        var seen = new HashSet<String>();

        if (text.length() < w)
            return 0;

        for (int i = 0; i <= text.length() - w; i++) {
            String ana = text.substring(i, i + w);
            if (!seen.contains(ana) && isAnagram(ana, word)) {
                count++;
                seen.add(ana);
            }
        }

        return count;
    }

    @Test
    public void testCountAnagram() {
        System.out.println(countAnagram("gotxxotgxdogt", "got"));
        Assertions.assertEquals(3, countAnagram("gotxxotgxdogt", "got"));
    }

    public int countOccurances(String text, String word) {
        int[] wHeap = new int[26];
        int[] textHeap = new int[26];
        int start = 0, count = 0;
        int wLen = word.length();

        for (char c : word.toCharArray()) {
            wHeap[c - 'a']++;
        }

        for (int i = 0; i < text.length(); i++) {
            textHeap[text.charAt(i) - 'a']++;

            if (i - start + 1 == wLen) {
                if (java.util.Arrays.equals(textHeap, wHeap)) {
                    count++;
                }

                textHeap[text.charAt(start) - 'a']--;
                start++;
            }
        }
        return count;
    }

    @Test
    public void testCountOccurances() {
        System.out.println(countOccurances("gotxxotgxdogt", "got"));
        Assertions.assertEquals(3, countAnagram("gotxxotgxdogt", "got"));
    }
}
