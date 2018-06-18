package DSA.Array.IntersectionofTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 *
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

Background: use for search engine inverted index
 */
class Solution {
    // BF O(N)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for (int num : res) {
            ans[i++] = num;
        }
        return ans;
    }
    // if sorted, use binary search or two pointers
    // if one is much smaller use BS, otherwise use two pointers
    public int[] intersectionII(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
    // BS too easy, just ignore here

    /*
     * Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

     */
    // 这时候就用hashMap来count 减掉该减的值
}