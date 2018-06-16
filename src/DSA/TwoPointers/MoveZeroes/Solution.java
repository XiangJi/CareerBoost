package DSA.TwoPointers.MoveZeroes;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative
 * order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 *     *All elements before the slow pointer (lastNonZeroFoundAt) are non-zeroes.
    *All elements between the current and slow pointer are zeroes.
    *
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // use a pointer to save index, swap 0 and number
        // O(2*non-zero)
        int index = 0; // slow pointer index to keep the firstZero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap with the first zero
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }

    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    // O(length)
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0)
                nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}