import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FindKthPermutationTest {

    /**
     * Swap Characters at position i and j
     * @return swapped string
     */
    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    /**
     * Use String permutations technique!!
     * 1st             ABC
     *            a/a  a|b   a\c
     * 2nd     ABC     BAC     CBA
     *        /  \     / \     /  \
     * 3rd   ABC ACB BAC BCA CBA CAB
     */
    private void permute(String str, int start, int end, List<String> result) {
        if (start == end) result.add(str);
        else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                permute(str, start + 1, end, result);
//                str = swap(str, start, i);
            }
        }
    }

    @Test
    public void testPermute() {
        String text = "157";
        int kth = 3;
        List<String> list = new ArrayList<>();
        permute(text, 0, text.length() - 1, list);
        List<Integer> collect = list.stream()
                .map(e -> Integer.parseInt(e))
                .sorted()
                .collect(Collectors.toList());
        Assertions.assertTrue(517 == collect.get(kth - 1));
        System.out.println("kth permutation is :: " + collect.get(kth - 1));
    }


    /**
     * 1. Calculate all numbers from given arr min to max
     * 2. Sort each number and check with sorted arr
     * 3. Keep the one we want.
     */
    private List<Integer> calc(int[] arr) {
        Arrays.sort(arr);
        int smallest = 0, largest = 0;
        String x = "", y = "";
        for (int i = 0; i < arr.length; i++) {
            x += String.valueOf(arr[i]);
            y += String.valueOf(arr[arr.length - i - 1]);
        }
        smallest = Integer.parseInt(x);
        largest = Integer.parseInt(y);

        List<Integer> res = new ArrayList<>();
        while (smallest <= largest) {
            String tmp = smallest + "";
            char[] split = tmp.toCharArray();
            int[] n_tmp = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                n_tmp[i] = Integer.parseInt(String.valueOf(split[i]));
            }
            Arrays.sort(n_tmp);
            if (Arrays.equals(n_tmp, arr))
                res.add(smallest++);
            smallest++;
        }
        return res;
    }

    @Test
    public void testCalc() {
        int kth = 3;
        List<Integer> calc = calc(new int[]{1, 5, 7});
        Assertions.assertTrue(517 == calc.get(kth - 1));
        System.out.println("kth permutation is : " + calc.get(kth - 1));
    }
}