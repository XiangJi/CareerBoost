package DSA.DynamicProgramming.MaximumVacationDays;

/*
 * Rules and restrictions:

You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on Monday.
The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical), called flights representing the airline status from the city i to the city j. If there is no flight from the city i to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1. Also, flights[i][i] = 0 for all i.
You totally have K weeks (each week has 7 days) to travel. You can only take flights at most once per day and can only take flights on each week's Monday morning. Since flight time is so short, we don't consider the impact of flight time.
For each city, you can only have restricted vacation days in different weeks, given an N*K matrix called days representing this relationship. For the value of days[i][j], it represents the maximum days you could take vacation in the city i in the week j.
 

You're given the flights matrix and days matrix, and you need to output the maximum vacation days you could take during K weeks.

Example 1:

Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
Output: 12
Explanation: 
Ans = 6 + 3 + 3 = 12. 
 * 我们建立一个二维DP数组，其中dp[i][j]表示目前是第j周，并且在此时在城市i，
 * 总共已经获得休假的总日子数。我们采取从后往前更新的方式(不要问我为什么，因为从前往后更新的写法要复杂一些)，
 * 我们从第k周开始往第一周遍历，那么最后结果都累加在了dp[i][0]中，
 * i的范围是[0, n-1]，找出其中的最大值就是我们能休息的最大假期数了。
 * 
 * 难点就在于找递推式了，我们想dp[i][j]表示的是当前是第j周并在城市i已经获得的休假总日子数，那么上一个状态，也就是j+1周(因为我们是从后往前更新)，
 * 跟当前状态有何联系，上一周我们可能还在城市i，也可能在其他城市p，那么在其他城市p的条件是，城市p有直飞城市i的飞机，
 * 那么我们可以用上一个状态的值dp[p][j+1]来更新当前值dp[i][j]，还要注意的是我们要从倒数第二周开始更新，因为倒数第一周没有上一个状态，还有就是每个状态dp[i][j]都初始化赋为days[i][j]来更新，这样一旦没有任何城市可以直飞当前城市，
 * 起码我们还可以享受当前城市的假期，最后要做的就是想上面所说在dp[i][0]中找最大值，下面的代码是把这一步融合到了for循环中，所以加上了一堆判断条件
 * 
 */
public class Solution {

    public int maxVacationDays(int[][] flights, int[][]days) {
        int n = flights.length, k = days[0].length, res = 0;
        int[][] dp = new int[n][k];
        for (int j = k - 1; j >= 0; --j) {
            for (int i = 0; i < n; ++i) {
                dp[i][j] = days[i][j];
                for (int p = 0; p < n; ++p) {
                    if ((i == p || flights[i][p] == 1) && j < k - 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j + 1] + days[i][j]);
                    }
                    if (j == 0 && (i == 0 || flights[0][i] == 1)) res = Math.max(res, dp[i][0]);
                }
            }
        }
        return res;
    }
}