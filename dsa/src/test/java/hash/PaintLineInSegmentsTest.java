package hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider a segmented line of unknown length, input are the segments!
 * Input: (4, 10) (7, 13) (20, 30) (1, 40)
 * Output:  6       3        10      20
 * Find how much paint is needed for each segment.
 */
public class PaintLineInSegmentsTest {

    public int paint(int[] x, Map<Integer, Boolean> line) {
        int count = 0;
        int start = x[0], end = x[1];
        for (;start < end;) {
            if (!line.containsKey(start)) {
                line.put(start, true);
                count++;
            }
            start++;
        }
        return count;
    }

    @Test
    public void test() {
        Map<Integer, Boolean> line = new HashMap<>();
        Assertions.assertEquals(6, paint(new int[]{4, 10}, line));
        Assertions.assertEquals(3, paint(new int[]{7, 13}, line));
        Assertions.assertEquals(10, paint(new int[]{20, 30}, line));
        Assertions.assertEquals(20, paint(new int[]{1, 40}, line));
    }
}
