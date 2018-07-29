package DSA.Array.FirstMissingPositive;

/*
 *
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.

既然不能建立新的数组，那么我们只能覆盖原有数组，我们的思路是把1放在数组第一个位置nums[0]，2放在第二个位置nums[1]，
即需要把nums[i]放在nums[nums[i] - 1]上，那么我们遍历整个数组，如果nums[i] != i + 1, 而nums[i]为整数且不大于n，
另外nums[i]不等于nums[nums[i] - 1]的话，我们将两者位置调换，如果不满足上述条件直接跳过，最后我们再遍历一遍数组，
如果对应位置上的数不正确则返回正确的数，

 */
public class Solution {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
                return 1;
        }

        for (int i = 0; i < A.length; i++) {
                // need swap when + , small than the length, and not the correct position
                // and avoid infinite loop by avoid
                while (A[i] > 0 && A[i] < A.length && A[i] != (i + 1)) {
                        int temp = A[A[i] - 1];
                        if (temp == A[i]) {
                                break;
                        }
                        A[A[i] - 1] = A[i];
                        A[i] = temp;
                }
        }

        for (int i = 0; i < A.length; i++) {
                if (A[i] != i + 1) {
                        return i + 1;
                        // 警察叔叔就是它！
                }
        }
        // if not missing
        return A.length + 1;

    }
}