package DSA.Array.FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

/*
 * 假设在位置k放了元素i，则在取负的过程中i的取值有两种可能：为正，
 * 表示当前尚未遇到元素k将该位置取负；为负，表示当前已经有元素k出现，并将元素取负。
 * 但是我们不关心k，我们关心元素i。元素i既然出现，我们就看一下位置i：为正，表示这是元素i第一次出现，
 * 我们将位置i取负；为负，表示元素i已经出现过一次，我们不做任何操作。不管一个元素出现一次还是两次，
 * 只要出现它对应的位置就会被取负。当某个元素不出现的时候，该元素对应的位置始终访问不到，
 * 所以还是正值，通过这种方法我们就可以找到哪些元素没有出现
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * 1 2 3 4 5 6 7 8
 * 0 1 2 3 4 5 6 7
 * 类似于桶排序bucket的思想
 * 看见1 - n里面放数字应该要想到
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] array = {4,3,2,7,8,2,3,1};
        test.findDisappearedNumbers(array);
    }
}
