package DSA.Stack.DailyTemperatures;

import java.util.Stack;

/*
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 BF is trival
 考察单调栈问题 类似有还有LC84, 85 next great element I
 高频题！
 O(N)
 实际上这道题应该使用递减栈Descending Stack来做，
 栈里只有递减元素，思路是这样的，我们遍历数组，如果栈不空，且当前数字大于栈顶元素，
 那么如果直接入栈的话就不是递减栈了，所以我们取出栈顶元素，那么由于当前数字大于栈顶元素的数字，
 而且一定是第一个大于栈顶元素的数，那么我们直接求出下标差就是二者的距离了，然后继续看新的栈顶元素，
 直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，且每个数字和第一个大于它的
 数的距离也可以算出来了

 */
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // store min index
        // descending stack
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int t = stack.peek();
                res[t] = i - t;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] list = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution test = new Solution();
        test.dailyTemperatures(list);
    }
}