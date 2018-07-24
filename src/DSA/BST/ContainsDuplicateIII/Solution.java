package DSA.BST.ContainsDuplicateIII;

import java.util.TreeSet;

/*
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

BF: 用一个sliding window扫过去 T(n*k)

BST 来找到最近的值，如果最近的值都不小于t 那么直接可以进入下一步 同时treeSet也可以通过删除来确定是不是sliding windows

LC 需要考虑数据越界 用long再存超过32bit的数据
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Check both side
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            } 
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
