import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://www.youtube.com/watch?v=jaNZ83Q3QGc
 */
public class CoinChangeTest {

    private int minCoinNeed(int amt, int coins[]) {
        if (amt == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amt - coin >= 0) {
                int subAns = minCoinNeed(amt - coin, coins);
                if(subAns + 1 < min) {// +1 to compensate for first deduction in previous step
                    min = subAns + 1;
                }
            }
        }
        return min;
    }

    @Test
    public void testMinCoinNeedNoDP() {
        int amount = 18;
        int[] coins = {1, 5, 7};
        Assertions.assertEquals(4, minCoinNeed(amount, coins));
    }

    /**
     * https://www.youtube.com/watch?v=-NTaXJ7BBXs
     */
    private int minCoinNeed(int amt, int coins[], int dp[]) {
        if (amt == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amt - coin >= 0) {
                int subAns = 0;
                if(dp[amt - coin] != -1) {
                    subAns = dp[amt - coin]; // if already present use it
                } else
                    subAns = minCoinNeed(amt - coin, coins, dp);
                if(subAns + 1 < min) {// +1 to compensate for first deduction in previous step
                    min = subAns + 1;
                }
            }
        }
        dp[amt] = min; // put the find min in dp
        return min;
    }

    @Test
    public void testMinCoinNeed() {
        int amount = 18;
        int[] coins = {1, 5, 7};
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);dp[0] = 0;
        Assertions.assertEquals(4, minCoinNeed(amount, coins, dp));
        Stream.of(dp).forEach(System.out::println);
        amount = 11; coins = new int[]{1, 2, 5}; Arrays.fill(dp, -1);dp[0] = 0;
        Assertions.assertEquals(3, minCoinNeed(amount, coins, dp));
        Stream.of(dp).forEach(System.out::println);
    }

    public int allCombPossible(int[] coins, int finalAmount) {
        int[] combinations = new int[finalAmount + 1]; // this array represents all amounts from 0 -> finalAmount
        combinations[0] = 1;

        for (int coin : coins) {
            for (int amount = coin; amount < combinations.length; amount++) {
                combinations[amount] += combinations[amount - coin];
            }
            System.out.println("for coin="+ coin +":" + Arrays.toString(combinations));
        }
        return combinations[combinations.length - 1];
    }

    @Test
    public void testAllCombPossible() {
        int[] denominations = new int[]{1, 2, 5};
        int amount = 12;
        int result = new CoinChangeTest().allCombPossible(denominations, amount);
        System.out.println("AllCombPossible(" + Arrays.toString(denominations) + ", " + amount + ") = " + result);
    }

}
