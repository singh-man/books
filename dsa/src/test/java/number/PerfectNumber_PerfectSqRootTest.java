package number;


import org.junit.jupiter.api.*;

import java.util.stream.IntStream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PerfectNumber_PerfectSqRootTest {

    /**
     * Perfect Number | Sum of its Divisors
     * 6              | 1 + 2 + 3
     * 28             | 1 + 2 + 4 + 7 + 14
     * 496            | 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248
     */
    private boolean isPerfectNumber(long n) {
        if (n == 1) return false;
        long divisorSum = 1; // 1 is divisor of every number
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                divisorSum += i;
            }
        }
        return divisorSum == n;
    }

    @Test
    @Order(10)
    public void perfectNumber() {
        IntStream.of(6, 28, 496)
                .forEach(i -> {
                    boolean perfect = isPerfectNumber(i);
                    Assertions.assertTrue(perfect, "Not a perfect number : " + i);
                });
    }

    @Test
    @Order(12)
    public void perfectNumberNot() {
        boolean perfect = isPerfectNumber(12);
        Assertions.assertFalse(perfect, "Not a perfect number : " + 12);
    }

    @Test
    @Order(1000)
    public void perfectNumber_big() {
        long n = 137438691328l;
        Assertions.assertTrue(isPerfectNumber(n), "Not a perfect number : " + n);

    }

    private long perfectNumber_recurse(long n, long i) {
        if (n == i) return 0;
        if (n % i == 0) {
            return i + perfectNumber_recurse(n, ++i);
        }
        return perfectNumber_recurse(n, ++i);
    }

    @Test
    @Order(20)
    public void perfectNumber_recurse_12() {
        long n = 12;
        long divisorSum = perfectNumber_recurse(n, 1);
        Assertions.assertNotEquals(n, divisorSum, "Found a perfect number : " + n);
    }

    @Test
    @Order(30)
    public void perfectNumber_recurse_496() {
        long n = 496;
        long divisorSum = perfectNumber_recurse(n, 1);
        Assertions.assertEquals(n, divisorSum, "Not a perfect number : " + n);
    }

    private boolean isPerfect_sqRoot(long n) {
        if (n == 1) return false;
        long divisorSum = 1; // 1 is divisor of every number
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                // n is a perfect square
                // let's take 25
                // we need to add 5 only once
                // divisorSum += i + n / i will add it twice
                if (i * i == n) divisorSum += i;
                else divisorSum += i + (n / i);
            }
        }
        return divisorSum == n;
    }

    @Test
    @Order(20)
    public void perfectSqRootNot() {
        long n = 12;
        Assertions.assertFalse(isPerfect_sqRoot(n), "Should not a perfect sq root : " + n);
    }

    @Test
    @Order(30)
    public void perfectSqRoot() {
        long n = 496;
        Assertions.assertTrue(isPerfect_sqRoot(n), "Perfect sq root : " + n);
    }

    @Test
    @Order(900)
    public void perfectSqRootBig() {
        long n = 137438691328l;
        Assertions.assertTrue(isPerfect_sqRoot(n), "Perfect sq root : " + n);
    }
}