package DSA.BinarySearch.SingleElementinaSortedArray;

/*
 * G 面经出现
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.
二分搜索法的难点在于折半了以后，如何判断将要去哪个分支继续搜索，而这道题确实判断条件不明显
但是对mid进行了处理，强制使其成为小伙伴对儿中的第一个位置，然后跟另一个小伙伴比较大小
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
         // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) mid--; // 不过不是even 往下挪一格 这样的话就确保了一直在check应该的pair
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2; // 如果一样 那么前面的都是pairs start = mid + 2
            }
        }

     // 'start' should always be at the beginning of a pair.
      // When 'start >= end', start must be the single element.
        return nums[start];
    }
}