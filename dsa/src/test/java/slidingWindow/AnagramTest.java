package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramTest {

    public List<String> findAllAnagrams(String text, String target) {
        List<String> anas = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (target.length() + i > text.length()) break;
            /**
             * 1. 0 -> target length
             * 2. 1 -> target length + 1
             */
            String substring = text.substring(i, target.length() + i);
            boolean anagram = isAnagram(target, substring);
            if (anagram)
                anas.add(substring);

        }
        return anas;
    }

    @Test
    public void testFindAllAnagrams() {
        List<String> allAnagrams = findAllAnagrams("abccba", "abc");
        allAnagrams.forEach(System.out::println);
    }

    public boolean isAnagram(String txt, String check) {
        char[] a = txt.toCharArray();
        Arrays.sort(a);
        char[] a1 = check.toCharArray();
        Arrays.sort(a1);
        return Arrays.equals(a, a1);
    }

    @Test
    public void test() {
        Assertions.assertEquals(true, isAnagram("cat", "act"));
        Assertions.assertEquals(false, isAnagram("cat", "abt"));
    }
}
