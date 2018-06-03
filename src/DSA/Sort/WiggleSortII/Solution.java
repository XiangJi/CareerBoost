package DSA.Sort.WiggleSortII;

import java.util.Arrays;

/*
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

1. Sort and reorder
2. Virtual index for follow up {hard!}
 */
public class Solution {
    // BF
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2)
            nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2)
            nums[j] = copy[i];
    }

    // HARD is virtual indexing, ignore
}