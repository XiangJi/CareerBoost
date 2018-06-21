package DSA.DynamicProgramming.Game.NimGame;

public class Solution {
    // 如果之前三个取到了 第四个一定娶不到
    public boolean canWinNim(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }

        boolean[] dp = new boolean[4];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i % 4] = !(dp[(i - 1) % 4] && dp[(i - 2) % 4] && dp[(i - 3) % 4]);
        }
        return dp[n % 4];

    }

    /* return n % 4 != 0;
     *
     */
    /*
     * 我们来generalize一下这道题，当可以拿1～n个石子时，那么个数为(n+1)的整数倍时一定会输，我们试着证明一下这个结论，若当前共有m*(n+1)个石子，那么：

当m=1时，即剩n+1个的时候，肯定会输，因为不管你取1～n中的任何一个数字，另一个人都可以取完。
当m>1时，即有m*(n+1)的时候，不管你先取1～n中的任何一个数字x，另外一个人一定会取n+1-x个，这样总数就变成了(m-1)*(n+1)，第二个人就一直按这个策略取，那么直到剩n+1个的时候，就便变成m=1的情况，一定会输。
     */

}