package DSA.Stack.NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

/*
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]

不同的是，此时数组是一个循环数组，就是说某一个元素的下一个较大值可以在其前面，
那么对于循环数组的遍历，为了使下标不超过数组的长度，我们需要对n取余，下面先来看暴力破解的方法，
遍历每一个数字，然后对于每一个遍历到的数字，遍历所有其他数字，注意不是遍历到数组末尾，
而是通过循环数组遍历其前一个数字，遇到较大值则存入结果res中，并break，

 */
public class Solution {
    //BF
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
    /*
     * 我们遍历两倍的数组，然后还是坐标i对n取余，取出数字，如果此时栈不为空，
     * 且栈顶元素小于当前数字，说明当前数字就是栈顶元素的右边第一个较大数，
     * 那么建立二者的映射，并且去除当前栈顶元素，最后如果i小于n，则
     * 把i压入栈。因为res的长度必须是n，超过n的部分我们只是为了给之前栈中的
     * 数字找较大值，所以不能压入栈，
     */
    public int[] nextGreaterElementsII(int[] nums) {
        int m = nums.length;
        int[] res = new int[m];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 2 * m; i++) {
            int num = nums[i % m];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < m) {
                stack.push(i);
            }
        }
        return res;
    }

}
