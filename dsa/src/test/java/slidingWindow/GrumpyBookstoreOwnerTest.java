package slidingWindow;

import org.junit.jupiter.api.Assertions;

/**
 * There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array of customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
 * For some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
 * When the bookstore owner is grumpy, the customers during that minute aren’t satisfied, otherwise, they are satisfied.
 * The bookstore owner knows a secret technique to keep themselves not grumpy for consecutive minutes but can only use it once.
 * Return the maximum number of customers that can be satisfied throughout the day.
 */
import org.junit.jupiter.api.Test;

public class GrumpyBookstoreOwnerTest {

    // Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
    // Output: 16
    // Explanation: The bookstore owner keeps themselves not grumpy for the last 3
    // minutes.
    // The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int res = 0;

        // Add customers who are always satisfied (grumpy[i] == 0)
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }

        // Sliding window to maximize additional satisfied customers
        int sum1 = 0;
        for (int i = 0; i < minutes && i < n; i++) {
            if (grumpy[i] == 1) {
                sum1 += customers[i];
            }
        }

        int result = sum1;

        for (int r = minutes; r < n; r++) {
            if (grumpy[r] == 1) {
                sum1 += customers[r];
            }
            if (grumpy[r - minutes] == 1) {
                sum1 -= customers[r - minutes];
            }
            result = Math.max(result, sum1);
        }

        return res + result;
    }

    @Test
    public void test() {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        Assertions.assertEquals(16, maxSatisfied(customers, grumpy, minutes));
    }
}
