package DSA.Misc.TargetSum;
/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

DFS can solve the question easily

Use DP for optimization
 */
public class Solution {
    int count = 0;
    // 2 ^ N
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S, 0);
        return count;
    }
    
    private void dfs(int[] nums, int sum, int target, int k) {
        if (k == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(nums, sum + nums[k], target, k + 1);
        dfs(nums, sum - nums[k], target, k + 1);
        return;
    }
    
    /* O(N * sum) total 2 * sum + 1 states
     *  画出并填充2d的state表格
     * DP
     * state: way[i][j] ways to sum up to j using nums[0 ~ i]
     * way[i][j] = way[i-1][j - nums[i]] + way[j + nums[i]]
     * way[-1][0] = 1, one way to sum up 0
     * Ans: way[n-1][S]
     */
    public int findTargetSumWaysII(int[] nums, int S) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(-sum>S||sum<S){
            return 0;
        }
        
        int[][] dp=new int[nums.length][2*sum+1];
        dp[0][sum+nums[0]]+=1;
        dp[0][sum-nums[0]]+=1;
        
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=2*sum;j++)
            {
                 if(dp[i-1][j]!=0){
                     dp[i][j-nums[i]]+=dp[i-1][j];
                     dp[i][j+nums[i]]+=dp[i-1][j];
                 }
            }        
        }
        return dp[nums.length - 1][sum + S];
    }
}