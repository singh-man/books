package slidingWindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumAdjacentSwapFor_K_ConsecutiveOnesTest {

    public int minMoves(int[] nums, int k) {
        // Step 1: Extract indices of all 1s
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                pos.add(i);
        }

        int n = pos.size();
        // Step 2: Build prefix sums of positions for O(1) range sum calculations
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + pos.get(i);
        }

        long minMoves = Long.MAX_VALUE;
        // Radius determines how many elements are on each side of the median
        int radius = (k - 1) / 2;

        // Step 3: Slide a window of size k through the pos list
        for (int i = radius; i < n - (k - 1 - radius); i++) {
            int left = i - radius;
            int right = i + (k - 1 - radius);

            // The optimal meeting point is the median index within the window
            long midPosValue = pos.get(i);

            // Sum of indices to the left and right of the median in current window
            long leftWindowSum = preSum[i] - preSum[left];
            long rightWindowSum = preSum[right + 1] - preSum[i + 1];

            // Formula: (Target sum centered at median) - (Actual sum of positions)
            // Subtracting the arithmetic sum (radius * (radius + 1) / 2) accounts
            // for the fact that elements must be adjacent, not overlapping.
            long leftMoves = (long) radius * midPosValue - leftWindowSum - (long) radius * (radius + 1) / 2;

            int rightCount = k - 1 - radius;
            long rightMoves = rightWindowSum - (long) rightCount * midPosValue
                    - (long) rightCount * (rightCount + 1) / 2;

            minMoves = Math.min(minMoves, leftMoves + rightMoves);
        }

        return (int) minMoves;
    }

    @Test
    @DisplayName("Basic case: 1s separated by 0s")
    void testBasicCase() {
        int[] nums = { 1, 0, 0, 1, 0, 1 };
        int k = 2;
        // Window [1, 4] -> cost to move to index 1 or 2 is 1 swap
        assertEquals(1, minMoves(nums, k));
    }

    @Test
    @DisplayName("Large gap case")
    void testLargeGap() {
        int[] nums = { 0, 1, 1, 0, 0, 1 };
        int k = 3;
        // Move all to be consecutive. Cheapest is moving to center (indices 1, 2, 5)
        assertEquals(2, minMoves(nums, k));
    }

    @Test
    @DisplayName("Already consecutive case")
    void testAlreadyConsecutive() {
        int[] nums = { 0, 1, 1, 1, 0, 0 };
        int k = 3;
        assertEquals(0, minMoves(nums, k));
    }

    @Test
    @DisplayName("Multiple windows: Choose cheapest")
    void testMultipleWindows() {
        int[] nums = { 1, 1, 0, 1 };
        int k = 2;
        assertEquals(0, minMoves(nums, k));
    }
}
