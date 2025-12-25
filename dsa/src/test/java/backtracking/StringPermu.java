package backtracking;

import org.junit.jupiter.api.Test;

/**
 * 1st             ABC
 *            a/a  a|b   a\c
 * 2nd     ABC     BAC     CBA
 *        /  \     / \     /  \
 * 3rd   ABC ACB BAC BCA CBA CAB
 */
public class StringPermu {

    /**
     * Swap Characters at position i and j
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    /**
     * in abc
     * start with swapping a -> a than go on
     */
    private void permute(String str, int start, int end) {
        if (start == end) System.out.println(str);
        else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                System.out.println("here :" + str);
                permute(str, start + 1, end);
//                str = swap(str, start, i);
            }
        }
    }

    @Test
    public void test() {
        String text = "abc";
        permute(text, 0, text.length() - 1);
        text = "abcd";
        permute(text, 0, text.length() - 1);
    }
}
