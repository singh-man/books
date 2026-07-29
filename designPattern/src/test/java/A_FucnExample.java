import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class A_FucnExample {

    private Function<String, String> f1() {
        return s -> "f1 : " + s;
    }

    private Function<String, String> f2() {
        return s -> "f2 : " + s;
    }

    private String F1(String s1) {
        return "F1 : " + s1;
    }

    private String F2(String s1) {
        return "F2 : " + s1;
    }

    @Test
    void test() {
        String result = f1().andThen(f2()).apply("manish");
        System.out.println(result);

        Function<String, String> F1 = s -> F1(s);
        System.out.println(F1.andThen(s -> F2(s)).apply("singh"));
    }
}
