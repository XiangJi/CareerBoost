package DSA.Array.NonDecreasingArray;

/*
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                // greedy like c
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }

        }
        return (count <= 1);
    }
}
