package DSA.Greedy.IncreasingTripletSubsequence;

/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false

min1, min2 三种case分类讨论
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
          if (num > min2) return true;
          else if (num < min1) {
            min1 = num;
          } else if (num > min1 && num < min2) {
            min2 = num;
          }
        }
        return false;
    }
}