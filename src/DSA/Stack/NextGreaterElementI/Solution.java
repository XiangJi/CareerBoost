package DSA.Stack.NextGreaterElementI;

import java.util.HashMap;
import java.util.Stack;

/*
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]

Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.

单调栈
 */
public class Solution {
    // BF 或者也可以把nums全放进hash表 O(M * N), S: O(m)
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        int j;
        for (int i = 0; i < findNums.length; i++) {
            boolean found = false;
            for (j = 0; j < nums.length; j++) {
                if (found && nums[j] > findNums[i]) {
                    res[i] = nums[j];
                    break;
                }
                if (nums[j] == findNums[i]) {
                    found = true;
                }
            }
            if (j == nums.length) {
                res[i] = -1;
            }
        }
        return res;
    }

    // STACK O(m+n) o(m + n)
    public int[] nextGreaterElementII(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

}
