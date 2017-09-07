package DSA.DynamicProgramming.Game.NimGame;

public class Solution {
    public boolean canWinNim(int n) {
        // game dp
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
        }
        return dp[n];
    }
    
    // return n % 4 != 0;
}