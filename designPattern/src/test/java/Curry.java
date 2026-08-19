import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class Curry {

    @Test
    public void test() {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> meanOfThree = new Function<>() {
            @Override
            public Function<Integer, Function<Integer, Integer>> apply(Integer first) {
                return new Function<Integer, Function<Integer, Integer>>() {
                    @Override
                    public Function<Integer, Integer> apply(Integer second) {
                        return new Function<Integer, Integer>() {
                            @Override
                            public Integer apply(Integer third) {
                                return (first + second + third) / 3;
                            }
                        };
                    }
                };
            }
        };
        Integer mean = meanOfThree.apply(10)
                .apply(20)
                .apply(30);
        Assertions.assertEquals(20, mean);

        // OR
        meanOfThree = first -> second -> three -> (first + second + three) / 3;
        mean = meanOfThree.apply(10)
                .apply(20)
                .apply(30);
        Assertions.assertEquals(20, mean);
    }
}
