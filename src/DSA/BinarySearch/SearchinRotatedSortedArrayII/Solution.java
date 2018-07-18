package DSA.BinarySearch.SearchinRotatedSortedArrayII;

// follow up, what if array contains duplicates

// just o(N) is the right solution
// if have to use binary search, like below logN ~ N
// if dup, just scan? why, give all same case

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
                start++;
                end--;
            } else if (nums[mid] >= nums[start]) {
                // mid at upper
                if ( nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // mid at lower
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}
