package DSA.Array.FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

将其值对应的位置上的那个元素取负数，当然因为元素的值是从1开始的，
所以变成位置的时候都要减一，每次换成位置时都要用绝对值来算，因为出现了两次的元素，
在之前就已经被变成负数了，所以借此可以判断，如果该位置的元素是个负数，说明之前出现过一次，就记录下来。

bucket思想
正负号标记法（一趟遍历）
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }
    
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.findDuplicates(new int[]{1,2,4,4,5,5,5,5}));
    }
}
