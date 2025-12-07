package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Fibonacci_FactorialTest {

    /**
     * n = fib(n-1) + fib(n-2)
     * exit criteria : n <= 1 -> return n
     */
    @Test
    public void fibonacci_1() {
        Function<Integer, Integer> fib = new Function<>() {
            @Override
            public Integer apply(Integer n) {
                if (n <= 1) return n;
                return apply(n - 1) + apply(n - 2);
            }
        };
        System.out.println(fib.apply(10));
        IntStream.range(0, 10)
                .forEach(i -> System.out.println(fib.apply(i)));
    }

    @Test
    public void fibonacci_withMemoization() {
        Map<Integer, Integer> cache = new HashMap<>();
        Function<Integer, Integer> fib = new Function<>() {
            @Override
            public Integer apply(Integer n) {
                if (cache.containsKey(n)) return cache.get(n);
                if (n <= 1) return n;
                int tmp = apply(n - 1) + apply(n - 2);
                cache.put(n, tmp);
                return tmp;
            }
        };
        System.out.println(fib.apply(10));
    }

    @Test
    public void fibonacci_2() {
        BiFunction<Integer, Integer, Long> fib = new BiFunction<>() {
            @Override
            public Long apply(Integer depth, Integer n) {
                String indent = new String(new char[depth]).replace('\0', ' ');
                long result;
                if (n == 0 || n == 1) {
                    result = n;
                    System.out.printf(indent + "fib(%s)-->%s%n", n, result);
                } else {
                    long first = apply(depth + 1, n - 1);
                    System.out.printf(indent + "fib(%s)%n", n);
                    long second = apply(depth + 1, n - 2);
                    result = first + second;
                }
                return result;
            }
        };
        fib.apply(0, 5);
    }

    /**
     * n = n * fact(n-1)
     * exit criteria : n == 0 | n == 1 -> return n
     */
    @Test
    public void factorial() {
        Function<Integer, Integer> fact = new Function<>() {
            @Override
            public Integer apply(Integer n) {
                if (n== 0 || n == 1) return n;
                return n * apply(n - 1);
            }
        };
        Assertions.assertEquals(120, fact.apply(5));
    }
}
