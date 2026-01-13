package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindDuplicatesWithin_range_K_arrTest {

    // ​Input: nums = [5, 6, 8, 2, 4, 6, 9]
    // k = 2
    // Output: False
    public static boolean getDuplicates(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    @Test
    public void test() {
        int[] nums = { 5, 6, 8, 2, 4, 6, 9 };
        int k = 2;
        Assertions.assertFalse(getDuplicates(nums, k));
    } 
}
