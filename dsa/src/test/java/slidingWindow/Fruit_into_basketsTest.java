package slidingWindow;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the ith tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * 
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * 
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * 
 * Given the integer array, return the maximum number of fruits you can pick.
 */
public class Fruit_into_basketsTest {

    // Input: fruits = [1,2,1]
    // Output: 3
    // Explanation: We can pick from all 3 trees.
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int longestLength = 0;
        var current = new HashMap<Integer, Integer>();

        for (int right = 0; right < n; right++) {
            current.put(fruits[right], current.getOrDefault(fruits[right], 0) + 1);

            while (current.size() > 2) {
                current.put(fruits[left], current.get(fruits[left]) - 1);
                if (current.get(fruits[left]) == 0) {
                    current.remove(fruits[left]);
                }
                left++;
            }

            int currentLength = right - left + 1;
            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }

    @Test
    public void test() {
        int[] fruits = { 1, 2, 1 };
        Assertions.assertEquals(3, totalFruit(fruits));
    }
}
