package DSA.DynamicProgramming.Game.PredicttheWinner;
/*
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the getScore. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the getScore and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the getScore.

Minimax

always pick the best for current local tree node

这道题给了一个小游戏，有一个数组，两个玩家轮流取数，说明了只能从开头或结尾取
，问我们第一个玩家能赢吗。这道题我想到了应该是用Minimax来做，由于之前有过一道这样的
题Guess Number Higher or Lower II，所以依稀记得应该要用递归的方法，而且当前玩家赢返回true的条件就是递
归调用下一个玩家输返回false。我们需要一个变量来标记当前是第几个玩家，还需要两个变量来分别记录两个玩家的
当前数字和，在递归函数里面，如果当前数组为空了，我们直接比较两个玩家的当前得分即可，如果数组中只有一个数字
了，我们根据玩家标识来将这个数字加给某个玩家并进行比较总得分。如果数组有多个数字，我们分别生成两个新数组，
一个是去掉首元素，一个是去掉尾元素，然后根据玩家标识分别调用不同的递归，只要下一个玩家两种情况中任意一
种返回false了，那么当前玩家就可以赢了，

花花酱 LeetCode 486. Predict the Winner
 */
public class Solution {
    // N^2
    public boolean PredictTheWinner(int[] nums) {
        return getScore(nums, 0, nums.length - 1) >= 0;
    }

    // max diff of (my score - opponent score) of subarray s ~ e
    public int getScore(int[] nums, int s, int e) {
        if (s == e)
            return nums[s];
        int a = nums[s] - getScore(nums, s + 1, e);
        int b = nums[e] - getScore(nums, s, e - 1);
        return Math.max(a, b);
    }

    // Search with cache N^2
    public boolean PredictTheWinnerII(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return getScore(nums, 0, nums.length - 1, memo) >= 0;
    }
    public int getScore(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - getScore(nums, s + 1, e, memo);
        int b = nums[e] - getScore(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }

    // iterative DP
    public boolean PredictTheWinnerIII(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int j=0; j < n; j++)
            for(int i=j; i>=0; i--)  {
                dp[i][j] = (i==j)? nums[i] : Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }

        return dp[0][n - 1] >= 0;
    }
}

