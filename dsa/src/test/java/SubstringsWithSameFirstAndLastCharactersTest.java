import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Input  : S = "abcab"
 * Output : 7
 * There are 15 substrings of "abcab"
 * a, ab, abc, abca, abcab, b, bc, bca
 * bcab, c, ca, cab, a, ab, b
 * Out of the above substrings, there
 * are 7 substrings : a, abca, b, bcab,
 * c, a and b.
 * <p>
 * Input  : S = "aba"
 * Output : 4
 * The substrings are a, b, a and aba
 */
public class SubstringsWithSameFirstAndLastCharactersTest {
    // assuming lower case only
    private static final int MAX_CHAR = 26;

    int countSubstringWithEqualEnds(String s) {
        int result = 0;
        int n = s.length();

        // Calculating frequency of each character
        // in the string.
        int[] count = new int[MAX_CHAR];
        for (int i = 0; i < n; i++)
            count[s.charAt(i) - 'a']++;

        // Computing result using counts
        // (Permutation and Combination formula) nCr = n!/(r!(n-r)!)
        // means a's frequency is 3 so, (a+1)Cr; Note r = 2 always
        // below is the simplification of Combination formula
        for (int i = 0; i < MAX_CHAR; i++)
            result += (count[i] * (count[i] + 1) / 2);

        return result;
    }

    @Test
    public void test() {
        Assertions.assertEquals(7, countSubstringWithEqualEnds("abcab"));
        Assertions.assertEquals(21, countSubstringWithEqualEnds("abcabadaea"));
    }

}
