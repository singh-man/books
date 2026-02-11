package monotonicStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondBiggestNumberTest {

    public int findSecondBiggestNumber(int[] arr) {
        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > biggest) {
                secondBiggest = biggest;
                biggest = i;
            } else if (i > secondBiggest && i != biggest) {
                secondBiggest = i;
            }
        }
        return secondBiggest;
    }

    @Test
    public void test() {
        int[] arr = { 1, 2, 3, 4, 5 };
        Assertions.assertEquals(4, findSecondBiggestNumber(arr));
        arr = new int[] { 5, 3, 2, 1, 4 };
        Assertions.assertEquals(4, findSecondBiggestNumber(arr));
        arr = new int[] { 5, 3, 2, 1, 4, 6, 9, 11, 14, 8, 5 };
        Assertions.assertEquals(11, findSecondBiggestNumber(arr));
    }
}