package DSA.DynamicProgramming.MaximumSubarray;
/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 重要经典DP题
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // Save some space
    public int maxSubArrayII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // initial
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // log sum
            max = Math.max(max, sum); // function

            // if sum < 0, start from 0;
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}