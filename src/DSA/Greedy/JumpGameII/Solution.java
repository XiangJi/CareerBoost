package DSA.Greedy.JumpGameII;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.

 */
public class Solution {
    public int jumpDP(int[] A) {
        // state
        int[] steps = new int[A.length];

        // initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        // function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        // answer
        return steps[A.length - 1];
    }

    // o(N)
    /*
     * 为了较快的跳到末尾，我们想知道每一步能跳的范围，这里贪婪并不是要在能跳的范围中选跳力最
     * 远的那个位置，因为这样选下来不一定是最优解，这么一说感觉又有点不像贪婪算法了。我们这里贪的是一
     * 个能到达的最远范围，我们遍历当前跳跃能到的所有位
     * 置，然后根据该位置上的跳力来预测下一步能跳到的最远距离，贪出一个最远的范围end，一旦当这个
     * 范围到达末尾时，当前所用的步数一定是最小步数。
     */
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
                curFarthest = Math.max(curFarthest, i + A[i]);
                if (i == curEnd) {
                        jumps++;
                        curEnd = curFarthest;
                }
        }
        return jumps;
}
}