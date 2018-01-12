package DSA.Misc.RangeSumQueryImmutable;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

Prefix sum, if changed, use binary index tree
 */
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sum.length == 0) {
            return 0;
        }
        if (i == 0) {
                return sum[j];
        }
        return sum[j] - sum[i - 1];
    }
}