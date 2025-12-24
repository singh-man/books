package dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Fibonacci {

    /**
     * n = fib(n-1) + fib(n-2)
     * exit criteria : n <= 1 -> return n
     */
    @Test
    public void fibonacci_recursion() {
        var fib = new Function<Integer, Integer>() {
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
    public void fibonacci_recursion_withMemoization() {
        Map<Integer, Integer> cache = new HashMap<>();
        var fib = new Function<Integer, Integer>() {
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
    public void fibonacci_recursion_withPrinting() {
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

    @Test
    public void fibonaccgii_tabulation() {
        var fib = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                if (n <= 1) return n;
                int[] dp = new int[n + 1];
                dp[0] = 0;
                dp[1] = 1;
                for (int i = 2; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
                return dp[n];
            }
        };
        Assertions.assertEquals(55, fib.apply(10));
        IntStream.range(0, 10)
                .forEach(i -> System.out.println(fib.apply(i)));
    }
}