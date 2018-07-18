package DSA.BinarySearch.FindKClosestElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104


 * 虽然也是用的二分搜索法，但博主搜的是第一个不小于x的数，
 * 然后同时向左右两个方向遍历，每次取和x距离最小的数加入结果res中，
 * 直到取满k个为止。但是下面这种方法更加巧妙一些，二分法的判定条件做了一些改变，
 * 就可以直接找到要返回的k的数字的子数组的起始位置，感觉非常的神奇。每次比较的是mid
 * 位置和x的距离跟mid+k跟x的距离，以这两者的大小关系来确定二分法折半的方向，最后找到最
 * 近距离子数组的起始位置，
 *
 * 考察2分法的条件变形能力
 * 
 * 0 。。。。 M 。 M + k。。。 N-k */
public class Solution {

    // nlogn
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
   }

    public List<Integer> findClosestElementsII(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;
        // search for the k beginning, 所有end起始位置是这样
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < x) { //这边加一层更加好理解
                if (x - arr[mid]> arr[mid + k] - x) { // 确定窗口的移动方向
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
