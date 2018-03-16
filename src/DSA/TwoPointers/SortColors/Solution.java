package DSA.TwoPointers.SortColors;
/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// 三指针的实现题目 0在左 1 不动 2在右边  0往左移动 1不动 2往右
 * counting sort
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index++, left++); // shift 0 to left
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right--); // shift 2 to right
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}