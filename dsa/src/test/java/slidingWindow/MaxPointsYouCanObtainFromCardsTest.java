package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * There are several cards arranged in a row, and each card has an associated
 * number of points. The points are given in the integer array cardPoints.
 * 
 * In one step, you can take one card from the beginning or from the end of the
 * row. You have to take exactly k cards.
 * 
 * Your score is the sum of the points of the cards you have taken.
 * 
 * Given the integer array cardPoints and the integer k, return the maximum
 * score you can obtain.
 */
public class MaxPointsYouCanObtainFromCardsTest {

    // Input: cardPoints = [1,2,3,4,5,6,1], k = 3
    // Output: 12
    // Explanation: After the first step, your score will always be 1. However,
    // choosing the rightmost card first will maximize your total score. The optimal
    // strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
    public int maxScore(int[] cardPoints, int k) {
        int score = 0;
        for (int i = 0; i < k; i++) {
            score += cardPoints[i];
        }

        int best = score;
        int n = cardPoints.length;

        for (int i = 1; i <= k; i++) {
            score = score - cardPoints[k - i] + cardPoints[n - i];
            best = Math.max(best, score);
        }

        return best;
    }

    @Test
    public void test() {
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        Assertions.assertEquals(12, maxScore(cardPoints, k));
    }
}
