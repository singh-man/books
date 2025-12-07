package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountStringInStringTest {
    /**
     * Count the number of times a String is used in a given String
     */
    public int countStringInString(String target, String toCount) {
        return target.split(toCount, -1).length - 1;
    }

    @Test
    public void testCountStringInString() {
        Assertions.assertEquals(2, countStringInString("isnotis", "is"));
        Assertions.assertEquals(1, countStringInString("isnotis", "not"));
    }
}
