package DSA.DynamicProgramming.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]

比较难的DP题目

需要排序 因为整除的被除数一定大一点
Arrays.sort

用count[]保存所有count 因为无法递推
pre[] 数组来记录能被整除的index
int index把最后的数存起来

     1 2 4 6 8
            1 2 4 6 8
     pre : -1 0 1 1 2
     count: 1 2 3 3 4

a % b = 0
b % c = 0
a % c = 0
   time : O(n^2)
     space : O(n)

     dp[x] = max(dp[x], dp[y] + 1)  其中： 0 <= y < x 且 nums[x] % nums[y] == 0

 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0, index = -1;

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) { // mark to be understand
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
