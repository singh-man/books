package hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [51, 53, 56, 54, 51, 52], the function should return 1.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1. Note: return 1 if none
 */
public class SmallestMissingPositiveInteger {

    public int withArrays(int[] A) {
        int n = A.length;
        boolean[] present = new boolean[n + 1];

        // Mark positives that are within [1..n]
        for (int x : A) {
            if (x > 0 && x <= n) {
                present[x] = true;
            }
        }

        // Find first missing positive
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        // If 1..n are all present, answer is n+1
        return n + 1;
    }

    public int withArraysSpaceOptimized(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    @Test
    public void test() {
        int[][] A = { { 1, 3, 6, 4, 1, 2 },
                { 1, 2, 3 },
                { -1, -3 },
                { 51, 53, 56, 54, 51, 52 } };
        Assertions.assertEquals(5, withArrays(A[0]));
        Assertions.assertEquals(4, withArrays(A[1]));
        Assertions.assertEquals(1, withArrays(A[2]));
        Assertions.assertEquals(1, withArrays(A[3]));
        Assertions.assertEquals(5, withArraysSpaceOptimized(A[0]));
        Assertions.assertEquals(4, withArraysSpaceOptimized(A[1]));
        Assertions.assertEquals(1, withArraysSpaceOptimized(A[2]));
        Assertions.assertEquals(1, withArraysSpaceOptimized(A[3]));
    }
}