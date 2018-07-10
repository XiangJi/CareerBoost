package DSA.DynamicProgramming.Game.NimGameIII;
/*
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从左边依次拿走 1 或 2 个硬币，直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。

请判定 第一个玩家 是输还是赢？
 */
public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     * state: f[x] 现在还剩x个硬币，现在先手取硬币的人最后最多取硬币价值
     * function: 
     * f[x] = max(min(f[x-2], f[x-3])+a[n-x] ) ， (min(f[x-3],f[x-4])+a[n-x]+a[n-x+1] )
     * intialize: 
        f[0] = 0
        f[1] = a[n-1]
        f[2] = a[n-2] + a[n-1]
     * Answer: f[n]

     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            sum[i] = sum[i -  1] + values[n - i];

        int[] dp = new int[n + 1];
        dp[1] = values[n - 1];
        for (int i = 2; i <= n; ++i)
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
            
        return dp[n]  > sum[n] / 2;
    }
    
    // follow up 从两边拿
    /*
     * state: f[x][y] 现在还第x到第y的硬币，现在先手取硬币的人最后最多取硬币价值
     *function: 
                 f[x][y] = max(min(f[x+2][y], f[x+1][y-1])+a[x] ) ,
                          (min(f[x][y-2], f[x+1][y-1])+a[y]  )
     *intialize: 
            f[x][x] = a[x],
            f[x][x+1] = max(a[x],a[x+1]),
        
     * Answer:f[0][n]
     */
    public boolean firstWillWinII(int[] values) {
        // write your code here
        
        int n = values.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; ++i)
            sum[i] = sum[i - 1] + values[i - 1];
            
        // s[i][j] = sum[j + 1] -  sum[i];
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][i] = values[i];
            
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i < n; ++i) {
                int j = i + len - 1;
                if (j >= n)
                    continue;
                int s = sum[j + 1] - sum[i];
                dp[i][j] = Math.max(s - dp[i + 1][j], s - dp[i][j - 1]);
            }
        }
        
        return dp[0][n - 1]  > sum[n] / 2;
    }
}
