package DSA.DynamicProgramming.ClimbingStairs;
/*
 * Give n stairs, find the number of ways to reach n, can climb 1 to 2 each time.
 */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        
    }
}