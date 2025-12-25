package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    /**
     * Given an array of strings, remove each string that is an anagram of an earlier string, then return the remaining array in sorted order.
     * <p>
     * Example
     * str = ['code', 'doce', 'ecod', 'framer', 'frame', 'rfame', 'famer']
     * <p>
     * Constraints
     * 0 ≤ n ≤ 1000
     * 0 ≤ m ≤ n
     * 1 ≤ length of text[i] ≤ 1000
     * Each string text[i] is made up of characters in the range ascii[a-z].
     */
    @Test
    public void funWithAnagrams() {
        List<String> input = List.of("code", "doce", "ecod", "framer", "frame", "rfame", "ecod", "interview", "viewinter",
                "jack", "ackj", "mary");
        BiFunction<String, String, Boolean> isAnagram = (s1, s2) -> {
            char[] a = s1.toCharArray();
            Arrays.sort(a);
            char[] a1 = s2.toCharArray();
            Arrays.sort(a1);
            return Arrays.equals(a, a1);
        };
        List<String> output = new ArrayList<>();
        for (String s : input) {
            boolean found = false;
            for (String out : output) {
                if (found = isAnagram.apply(out, s))
                    break;
            }
            if (!found)
                output.add(s);
        }
        output.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void funWithAnagrams_1() {
        List<String> input = List.of("code", "doce", "ecod", "framer", "frame", "rfame", "ecod", "interview", "viewinter",
                "jack", "ackj", "mary");
        var unique = new HashMap<String, Integer>();
        for (int i = 0; i < input.size(); i++) {
            char[] text = input.get(i).toCharArray();
            Arrays.sort(text);
            if (!unique.containsKey(new String(text)))
                unique.put(new String(text), i);
        }
        List<String> out = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : unique.entrySet()) {
            out.add(input.get(entry.getValue()));
        }
        out.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }
}