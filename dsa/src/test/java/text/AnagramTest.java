package text;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class AnagramTest {

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
        Map<String, Integer> unique = new HashMap<>();
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