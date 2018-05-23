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