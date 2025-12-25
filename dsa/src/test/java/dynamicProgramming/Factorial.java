package dynamicProgramming;

import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Factorial {
    /**
     * n = n * fact(n-1)
     * exit criteria : n == 0 | n == 1 -> return n
     */
    @Test
    public void factorial_recursion() {
        var fact = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                if (n== 0 || n == 1) return n;
                return n * apply(n - 1);
            }
        };
        Assertions.assertEquals(120, fact.apply(5));
    }

    @Test
    public void factorial_tabulation() {
        Function<Integer, Integer> fact = n -> {
                if (n == 0 || n == 1) return n;
                int[] dp = new int[n + 1];
                dp[0] = 1;
                dp[1] = 1;
                for (int i = 2; i <= n; i++) {
                    dp[i] = i * dp[i - 1];
                }
                return dp[n];
            };
        Assertions.assertEquals(120, fact.apply(5));
    }
}
