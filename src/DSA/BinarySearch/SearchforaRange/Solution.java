package DSA.BinarySearch.SearchforaRange;
/*
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        // find the left bound
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target){
                end = mid;
            } else {
                  start = mid;
            }
        }

        if (nums[start] == target) {
            result[0] = start;
        } else if (nums[end] == target) {
            result[0] = end;
        }



        // find the right bound
        start = 0;
        end = nums.length - 1;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) {
            result[1] = end;
        } else if (nums[start] == target) {
            result[1] = start;
        }

        return result;
    }
}