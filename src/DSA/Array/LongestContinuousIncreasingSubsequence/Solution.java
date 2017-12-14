package DSA.Array.LongestContinuousIncreasingSubsequence;

/*
 * 0-D DP
 * Given an unsorted array of integers,
 * find the length of longest continuous increasing subsequence (subarray).
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        int result = 1;
        // test case, 1; 1 2 3 5 4
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                // reset
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result;
     }
}