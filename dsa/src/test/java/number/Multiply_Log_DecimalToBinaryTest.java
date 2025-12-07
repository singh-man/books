package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

public class Multiply_Log_DecimalToBinaryTest {

    @Test
    public void testMultiply() {
        BiFunction<Integer, Integer, Integer> multiply = new BiFunction<>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                if (x <= 0) return x;
                return apply(x - 1, y) + y;
            }
        };
        Assertions.assertEquals(6, multiply.apply(2, 3));
        Assertions.assertEquals(27, multiply.apply(9, 3));
    }

    @Test
    public void testLog() {
        BiFunction<Integer, Integer, Integer> log = new BiFunction<>() {
            @Override
            public Integer apply(Integer b, Integer n) {
                if (n <= b) {
                    return 1;
                } else {
                    return apply(b, n / b) + 1;
                }
            }
        };
        Assertions.assertEquals(3, log.apply(10, 1000));
        Assertions.assertEquals(2, log.apply(2, 4));
    }

    private BiFunction<Integer, String, String> toBinary = (n, s) -> n == 0 ?
            s : this.toBinary.apply(n / 2, n % 2 + s);

    @Test
    public void testDecimalToBinary() {
        BiFunction<Integer, String, String> decimalToBinary = new BiFunction<>() {
            @Override
            public String apply(Integer num, String res) {
                if (num == 0) return res;
                String str = num % 2 + res;
                return apply(num / 2, str);
            }
        };
        Assertions.assertEquals("1010", decimalToBinary.apply(10, ""));
        Assertions.assertEquals("1010", toBinary.apply(10, ""));
    }
}