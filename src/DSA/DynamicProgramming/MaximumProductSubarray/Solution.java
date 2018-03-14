package DSA.DynamicProgramming.MaximumProductSubarray;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.


 */
public class Solution {
    // DP should use N
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        // Because maybe negative, also need to keep min 
        //    max min 辅助dp数组
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];
        int result = nums[0];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // compare with current, because might be zero
            maxProduct[i] = Math.max(Math.max(maxProduct[i - 1] * nums[i],minProduct[i - 1] * nums[i]),nums[i]);
            minProduct[i] = Math.min(Math.min(maxProduct[i - 1] * nums[i],minProduct[i - 1] * nums[i]),nums[i]);
            result = Math.max(result, maxProduct[i]);
        }
        return result;
    }
}