package DSA.DynamicProgramming.BackPack.CoinChange;

/*
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

一维的背包DP问题

dp[amount] : the minimun number of coins for amount i

min = Math.min(min, dp[i - coins[j]] + 1);

using first j coins, j这个维度只是在遍历

 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // corner case: clarification and write, can be done in the end or during the implementation
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { // DP 层
            int min  = Integer.MAX_VALUE; // 每次求出当前的最小值
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) { // 之前的格子可以跳到
                    min = Math.min(min, dp[i - coins[j]] + 1); // 跳一步
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

       return dp[amount];
    }

    // run a simple test case: {1, 2} 4
}