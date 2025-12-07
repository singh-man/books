import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


public class BracesCheckTest {

    /**
     * This can not handle text in between
     */
    public boolean bracesWithText(String text) {
        if (text.length() % 2 != 0) return false;
        char[] x = text.toCharArray();
        Stack<Character> open = new Stack<>();
        Queue<Character> close = new ArrayDeque<>();
        for (char c : x) {
            if (c == '[' || c == '{' || c == '(') open.push(c);
            if (c == ']' || c == '}' || c == ')') close.add(c);
        }
        int size = open.size();
        for (int i = 0; i < size; i++) {
            String brks = open.pop().toString() + close.poll().toString();
            if (brks.equals("[]") || brks.equals("{}") || brks.equals("()"))
                continue;
            else return false;
        }
        return true;
    }

    @Test
    public void testBracesWithText() {
        Assertions.assertEquals(true, bracesWithText("[aa[[]]cc]"));
        Assertions.assertEquals(false, bracesWithText("[aa[x[b]y]cc]"));
        Assertions.assertEquals(false, bracesWithText("[a{]c]"));
        Assertions.assertEquals(false, bracesWithText("[[[[}}[]]]"));
        Assertions.assertEquals(false, bracesWithText("[{}()]")); // can not cover this
        Assertions.assertEquals(false, bracesWithText("[{}]}"));
    }

    /**
     * This can handle text in between as well
     */
    public boolean bracesWithTextUsingStack(String text) {
        char[] x = text.toCharArray();
        Stack<Character> open = new Stack<>();
        for (char c : x) {
            if (c == '[' || c == '{' || c == '(') {
                open.push(c);
            } else if (c == ']' || c == '}' || c == ')') {
                if (open.isEmpty()) return false;// close bracket without open
                Character pop = open.pop();
                switch (c) {
                    case ']':
                        if (pop == '[') break;
                        return false;
                    case '}':
                        if (pop == '{') break;
                        return false;
                    case ')':
                        if (pop == '(') break;
                        return false;
                }
            }
        }
        return open.isEmpty() ? true : false;
    }

    @Test
    public void testBracesWithTextUsingStack() {
        Assertions.assertEquals(true, bracesWithTextUsingStack("[aa[[]]cc]"));
        Assertions.assertEquals(false, bracesWithTextUsingStack("[a{]c]"));
        Assertions.assertEquals(false, bracesWithTextUsingStack("[[[[}}[]]]"));
        Assertions.assertEquals(true, bracesWithTextUsingStack("[{}()]")); // can cover this
        Assertions.assertEquals(false, bracesWithTextUsingStack("[{}]}"));
    }

    /**
     * Input like [], [[]], [[[]]
     */
    public boolean bracesOnly(String text) {
        if (text.length() % 2 != 0) return false;
        if ("".equals(text)) return true;
        if (null == text) return false;

        char[] chars = text.toCharArray();
        if (chars[0] == '[' && chars[chars.length - 1] == ']') {
            return bracesOnly(text.substring(1, text.length() - 1));
        } else
            return false;
    }

    @Test
    public void testBracesOnly() {
        Assertions.assertNotEquals(true, bracesOnly("[aa[[]]cc]"));
        Assertions.assertEquals(true, bracesOnly("[[[]]]"));
        Assertions.assertEquals(false, bracesOnly("[{]]"));
        Assertions.assertEquals(false, bracesOnly("[{}()]")); // can not cover this
        Assertions.assertNotEquals(true, bracesOnly("[[[[]]]"));
        Assertions.assertEquals(false, bracesOnly("[{}]}"));
    }
}