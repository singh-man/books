package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * x ↑↑ n  =  x ^ (x ↑↑ (n-1))
 * 2 ↑↑ 3  =  2 ^ (2 ↑↑ (3-1))
 *         =  2 ^ (2 ^ (2 ^ (2-1))))
 *         =  2 ^ 4
 */
public class Tetration {

    double tetration(double x, double n) {
        if (n == 0)
            return 1;
        else
            return Math.pow(x, tetration(x, n-1));
    }

    @Test
    public void test() {
        Assertions.assertEquals(16, tetration(2, 3));
        System.out.println(tetration(3, 3));
    }
}
