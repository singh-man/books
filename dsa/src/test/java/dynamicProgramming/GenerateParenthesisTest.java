package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GenerateParenthesisTest {

    public void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        // if the count of both open and close parentheses reaches n, it means we have generated a valid parentheses.
        // So, we add the currently generated string s to the final ans and return.
        if (open == n && close == n) {
            System.out.println("adding : " + s);
            ans.add(s);
            return;
        }

        // At any index i in the generation of the string s, we can put an open parentheses only if its count
        // until that time is less than n.
        if (open < n) {
            System.out.println("open : " + s + "{");
            generateParenthesis(n, open + 1, close, s + "{", ans);
        }

        // At any index i in the generation of the string s, we can put a closed parentheses only if its count
        // until that time is less than the count of open parentheses.
        if (close < open) {
            System.out.println("close : " + s + "}");
            generateParenthesis(n, open, close + 1, s + "}", ans);
        }
    }

    @Test
    public void testGenerateParenthesis() {
        ArrayList<String> ans = new ArrayList<>();
        new GenerateParenthesisTest().generateParenthesis(3, 0, 0, "", ans);
        ans.forEach(System.out::println);
    }
}
