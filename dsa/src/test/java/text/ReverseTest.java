package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import utils.FileUtils;
import utils.timer.TimeTaken;
import utils.timer.TimeTakenHelper;

import java.io.File;
import java.util.Stack;
import java.util.function.Function;

public class ReverseTest {

    private static Function<String, String> reverseStringUsingStack() {
        Function<String, String> f = s -> {
            Stack<Character> st = new Stack<>();
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                st.push(arr[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(st.pop());
            }
            return sb.toString();
        };
        return f;
    }

    @Test
    public void testReverseString_Stack() {
        Function<String, String> f = reverseStringUsingStack();
        Assertions.assertEquals("hsinam", f.apply("manish"));
    }

    @Test
    public void testReverseString_Array() {
        Function<String, String> f = s -> {
            char[] arr = s.toCharArray();
            int sLen = arr.length;
            char[] revArr = new char[sLen];
            for (int i = sLen - 1, j = 0; i >= 0; i--, j++) {
                revArr[j] = arr[i];
            }
            return new String(revArr);
        };
        Assertions.assertEquals("hsinam", f.apply("manish"));
    }

    @Test
    public void testReverseString_bySwaping() {
        Function<String, String> f = s -> {
            char[] arr = s.toCharArray();
            int sLen = arr.length;
            for (int i = 0, j = sLen - 1; i < sLen / 2; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        };
        Assertions.assertEquals("hsinam", f.apply("manish"));
    }


   @Test
   public void testReverseString() {
       final String orig = FileUtils.readFile(
                        new File("src/test/java/text/string.text"))
               .stream().reduce(String::concat).get();
       final String reverseStringUseStack = reverseStringUsingStack().apply(orig);
       System.out.println(reverseStringUseStack);
       TimeTakenHelper.calculateTime("Time by Stack way", new TimeTaken() {

           @Override
           public void calculateTimeTaken() {
               reverseStringUsingStack().apply(orig);
           }
       });
       TimeTakenHelper.calculateTime("Time by reverse array way", new TimeTaken() {

           @Override
           public void calculateTimeTaken() {
               Assertions.assertEquals(reverseStringUseStack, reverseStringUsingStack().apply(orig));
           }
       });
       TimeTakenHelper.calculateTime("Time by Swaping way", new TimeTaken() {

           @Override
           public void calculateTimeTaken() {
               Assertions.assertEquals(reverseStringUseStack, reverseStringUsingStack().apply(orig));
           }
       });
   }
}