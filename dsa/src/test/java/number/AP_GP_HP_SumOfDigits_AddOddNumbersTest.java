package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class AP_GP_HP_SumOfDigits_AddOddNumbersTest {

    // Functional Style Recursion
    final Function<Integer, Integer> sumOfN_numbers = i -> i == 0 ? i : i + this.sumOfN_numbers.apply(i - 1);

    /**
     * Sum = (First number + Last number) * <Total numbers>/2
     * Sn = n/2[2a + (n − 1) × d]
     *
     * @param n = total number
     * @param a = first number -> a1
     *          a\_n = a\_1 + (n-1)d
     * @param d = diff between 2 numbers
     */
    private int ap(int n, int a, int d) {
        return (n / 2) * (2 * a + (n - 1) * d);
    }

    @Test
    public void testSumOfN() {
        Function<Integer, Integer> sumOfN = new Function<>() {
            @Override
            public Integer apply(Integer num) {
                if (num <= 0) return 0;
                return num + apply(num - 1);
            }
        };
        Assertions.assertEquals(55, sumOfN.apply(10));
        Assertions.assertEquals(Integer.valueOf(55), sumOfN_numbers.apply(10));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> ap_curryStyle =
                n -> d -> a -> (n / 2) * (2 * a + (n - 1) * d);
        Assertions.assertEquals(sumOfN.apply(10), ap(10, 1, 1));
        Assertions.assertEquals(sumOfN_numbers.apply(10), ap_curryStyle.apply(10).apply(1).apply(1));
    }

    /**
     * Sn = a(rn - 1) / (r - 1)
     */
    @Test
    public void gp() {
        int[] data = {2, 4, 8, 16, 32};
        int a = data[0], r = 2, n = data.length;
        double total = a * (Math.pow(r, n) - 1) / (r - 1);
        Assertions.assertEquals(62, total);
    }

    @Test
    public void hp() {
        System.out.println("To be implemented!!");
    }

    @Test
    public void test_sumOfAllDigits() {
        Function<Integer, Integer> sum = new Function<>() {
            @Override
            public Integer apply(Integer num) {
                if (num == 0) return num;
                return num % 10 + apply(num / 10);
            }
        };
        Assertions.assertEquals(10, sum.apply(1234));
        Assertions.assertEquals(23, sum.apply(1598));
        Assertions.assertNotEquals(21, sum.apply(1598));
    }

    @Test
    public void testAddOddNumbers() {
        Function<Integer, Integer> addOdd = new Function<>() {
            @Override
            public Integer apply(Integer num) {
                if (num <= 0) return num;
                if (num % 2 != 0) {
                    return num + apply(num - 1); // if odd add value
                } else
                    return apply(num - 1); // if even recall
            }
        };
        Assertions.assertEquals(4, addOdd.apply(4));
        Assertions.assertEquals(16, addOdd.apply(7));
    }
}