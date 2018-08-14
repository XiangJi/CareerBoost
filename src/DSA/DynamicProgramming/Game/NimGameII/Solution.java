package DSA.DynamicProgramming.Game.NimGameII;

/*
 * 一堆卡片从一头拿，可以拿一二三张，两
 * 人轮流拿，求最高得分。小哥直接表示有负数的情况。我刚吃了饭
 * 有点懵，推出了正数的情况但是卡在了含负数的情况。然后小哥说那就先不
 * 考虑负数吧。随后还给了点 hint，然后就写出来了。并且让我在一个例子上过
 * 了一遍，问了问用什么 case 来测。
 *dp[i][j]  表示当前 player 在局面 arr[i.....j] 的情况下能取到最大值
转移方程是考虑从 i 或者 j 开始取至多 3 个.
dp[i][j] = max(sum[i+k][j] - dp[i+k][j] + sum[i][i+k]) 1<=k<=3.
dp[i][j] = max(sum[i][j-k] - dp[i][j-k] + sum[j-k][j]) 1<=k<=3
这里可以用 memorization 做优化.
这个是两边的情况

 *
 * 一维dp，递推方程minimax没错， 一维dp，最小值中找最大
 *
 * G 面经 这两个月高频
 */
public class Solution {
    public int nimGameMax(int[] n) {
        int[] dp = new int[n.length+1];// the max score I can get at
        //直接用predict winner的方法去推
        return 0;
    }
}
