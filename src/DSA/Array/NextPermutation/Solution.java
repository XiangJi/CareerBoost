package DSA.Array.NextPermutation;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

BF: backtracking and store data in array index, O(n!) TLE, Space O(N)

找规律算法 从右往左找第一个 a[i] > a[i - 1], swap, i 然后reverse后面的
Intuition: 下一个最大的规律
从右往左找第一个 a[i] > a[i - 1]
然后A[i] 从后往前找第一个比A[i]打的数A[j]
然后swap
然后把j后面的数reverse

// 1　　2　　7　　4　　3　　1
             ^
     // 1　　2　　7　　4　　3　　1
                          ^
     // 1　　3　　7　　4　　2　　1
             ^            ^
     // 1　　3　　1　　2　　4　　7
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        // scan from back, find A[i] > a[i - 1]
        int small = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                small = i;
                break;
            }
        }
        // !! Case, no such small, just reverse the whole thing
        if (small == -1) {
            reverse(0, nums.length - 1, nums);
            return;
        }

        // find the one greater
        int large = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[small]) {
                large = i;
                break;
            }
        }

        swap(small, large, nums);
        reverse(small + 1, nums.length - 1, nums);
        return;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i++, j--, nums);
        }
    }
}