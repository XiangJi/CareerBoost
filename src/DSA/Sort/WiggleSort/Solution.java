package DSA.Sort.WiggleSort;

/*
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

Greedy make it meet the requirement

一遍扫满足条件不管 不满足就前后swap就行
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                //swap
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}