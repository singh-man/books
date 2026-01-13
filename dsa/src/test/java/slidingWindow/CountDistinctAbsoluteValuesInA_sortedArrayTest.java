package slidingWindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountDistinctAbsoluteValuesInA_sortedArrayTest {

    // Input: { -1, -1, 0, 1, 1, 1 }
    // Output: The total number of distinct absolute values is 2 (0 and 1)
    public static int getCountDistinct(int[] arr) {
        Set<Integer> d = new HashSet<>();
        int count = 0;

        for (int item : arr) {
            int absItem = Math.abs(item);
            if (!d.contains(absItem)) {
                d.add(absItem);
                count++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        int[] arr = { -1, -1, 0, 1, 1, 1 };
        Assertions.assertEquals(2, getCountDistinct(arr));
    }
}
