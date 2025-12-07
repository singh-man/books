package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SearchMinWithCountTest {

    private record Min(int value, long count) {}

    private Min findMin(List<Integer> clientIds, Comparator<Integer> compare) {
        int oldest = clientIds.get(0);
        long count = 1;
        for (int i = 1; i < clientIds.size(); i++) {
            int status = compare.compare(oldest, clientIds.get(i));
            if (status > 0) {
                oldest = clientIds.get(i);
                count = 1;
            } else if (status == 0) {
                count++;
            }
        }
        return new Min(oldest, count);
    }

    @Test
    public void test() {
        Min min = new SearchMinWithCountTest().findMin(Arrays.asList(1, 1, 0, 3, 4, 6, 4, -1, -1, 10), Comparator.comparing(e -> e));
        Assertions.assertEquals(min.value, -1);
        Assertions.assertEquals(min.count, 2);
    }
}