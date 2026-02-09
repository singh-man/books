package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class FindTargetSumInAnArrayTest {

    public List<int[]> findPairs(int[] arr, final int target) {
        Set<Integer> seen = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                pairs.add(new int[] { complement, num });
            }
            seen.add(num);
        }

        return pairs;
    }

    @Test
    public void test() {
        int[] arr = { 4, 1, 3, 2, 5 };
        int target = 5;
        List<int[]> result = findPairs(arr, target);

        // Printing results
        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
        // Output:
        // (1, 4)
        // (3, 2)
    }

}