package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FindTargetSumInAnArrayTest {

    public List<int[]> findPairs(int[] arr, final int target) {
        Arrays.sort(arr); // Sorting takes O(N log N)
        List<int[]> pairs = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                pairs.add(new int[]{arr[left], arr[right]});
                left++;
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
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