package DSA.DynamicProgramming.Game.GuessNumberHigherorLowerII;

/*
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

DP[i, j] 肯定赢需要多少钱
 2D DP 但是有参数x
Minimax problem:
i ~ j 中 任意猜一个数 x 获胜需要钱 x + max(help(i, x -1),help(x + 1, j))
--> // the max means whenever you choose a number,
the feedback is always bad and therefore leads you to a worse branch.
then we get DP([i~j]) = min{xi, ... ,xj}
--> // this min makes sure that you are minimizing your cost.

或者记忆化搜索
根据题目中的提示，这道题需要用到Minimax极小化极大算法，
关于这个算法可以参见这篇讲解，并且题目中还说明了要用DP来做，那么我们需要建立一
个二维的dp数组，其中dp[i][j]表示从数字i到j之间猜中任意一个数字最少需要花费的钱数，那么
我们需要遍历每一段区间[j, i]，维护一个全局最小值global_min变量，然后遍历该区间中的每一个数
字，计算局部最大值local_max = k + max(dp[j][k - 1], dp[k + 1][i])，这个正好是将该区间在每
一个位置都分为两段，然后取当前位置的花费加上左右两段中较大的花费之和为局部最大值，为啥要取两者之间
的较大值呢，因为我们要cover所有的情况，就得取最坏的情况。然后更新全局最小值，最后在更新dp[j][i]的时候
看j和i是否是相邻的，相邻的话赋为i，否则赋为global_min。这里为啥又要取较小值呢，因为
dp数组是求的[j, i]范围中的最低cost，比如只有两个数字1和2，那么肯定是猜1的cost低，是不有
点晕，没关系，博主继续来绕你。我们想，如果只有一个数字，那么我们不用猜，cost为0。如果有两个数字，
比如1和2，我们猜1，即使不对，我们cost也比猜2要低。如果有三个数字1，2，3，那么我们就先猜2，根据对方
的反馈，就可以确定正确的数字，所以我们的cost最低为2。如果有四个数字1，2，3，4，那么情况就有点复杂了
，那么我们的策略是用k来遍历所有的数字，然后再根据k分成的左右两个区间，取其中的较大cost加上k。


当k为1时，左区间为空，所以cost为0，而右区间2，3，4，根据之前的分析应该取3，所以整个cost就是1+3=4。

当k为2时，左区间为1，cost为0，右区间为3，4，cost为3，整个cost就是2+3=5。

当k为3时，左区间为1，2，cost为1，右区间为4，cost为0，整个cost就是3+1=4。

当k为4时，左区间1，2，3，cost为2，右区间为空，cost为0，整个cost就是4+2=6。

综上k的所有情况，此时我们应该取整体cost最小的，即4，为最后的答案，这就是极小化极大算法，
 */
public class Solution {
    int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return helper(1, n);
    }

    private int helper(int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            res = Math.min(res, x + Math.max(helper(i, x - 1), helper(x + 1, j)));
        }
        dp[i][j] = res;
        return res;
    }

    // Bottom up solution
    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = i; x < j; x++) {
                    dp[i][j] = Math.min(dp[i][j], x + Math.max(dp[i][x - 1], dp[x + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

}
