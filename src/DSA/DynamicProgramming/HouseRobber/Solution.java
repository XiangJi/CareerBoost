package DSA.DynamicProgramming.HouseRobber;
/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i-1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
        }
        return dp[nums.length % 2];
         // 写完dp之后再改滚动
        
    }
}