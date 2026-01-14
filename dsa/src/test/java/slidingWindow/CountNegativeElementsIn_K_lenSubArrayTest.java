package slidingWindow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountNegativeElementsIn_K_lenSubArrayTest {
    
    // Input: arr = [-1, 2, -2, 3, 5, -7, -5], K = 3
    // Output: 2, 1, 1, 1, 2
    public List<Integer> getCountNegatives(int[] arr, int k) {
        var lst = new ArrayList<Integer>();
        int start = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
            }

            if (i - start + 1 == k) {
                lst.add(count);
                if (arr[start] < 0) {
                    count--;
                }
                start++;
            }
        }

        return lst;
    }

    @Test
    public void test() {
        int[] arr = { -1, 2, -2, 3, 5, -7, -5 };
        int k = 3;
        Assertions.assertEquals(List.of(2, 1, 1, 1, 2), getCountNegatives(arr, k));
    }
}