package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotatedStringTest {

    public boolean rotatedString(String orig, String rot) {
        if ((orig + orig).contains(rot)) return true;
        return false;
    }

    @Test
    public void rotatedString() {
        Assertions.assertTrue(rotatedString("Manish", "nishMa"));
        Assertions.assertFalse(rotatedString("Manish", "nishma"));
    }
}
