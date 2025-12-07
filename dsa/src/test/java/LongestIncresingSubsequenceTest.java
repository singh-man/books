import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncresingSubsequenceTest {

    int lis(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

        Arrays.fill(lis, 1);

        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && // if next value is greater in array
                        lis[i] < lis[j] + 1) // if in lis the value is decreasing
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    @Test
    public void test() {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n));
    }
}
