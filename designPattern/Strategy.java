package dp;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Strategy {

    private void publishText(String text,
                             Predicate<String> filter,
                             UnaryOperator<String> format) {
        if (filter.test(text)) {
            System.out.println(format.apply(text));
        }
    }

    @Test
    public void test() {
        publishText("ERROR - something bad happened", s -> true, String::toUpperCase);
        publishText("DEBUG - I'm here", s -> s.length() < 20, String::toLowerCase);
    }
}