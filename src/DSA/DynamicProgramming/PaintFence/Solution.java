package DSA.DynamicProgramming.PaintFence;
/*
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

不是典型的一维 需要直接用概念滚动优化

number of ways 就看可以从哪几个dp格子跳过来
 */
class Solution {
    // no 3 adj has the same color
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        // 1 2 3 compare, check if 23 same or not
        int same = 0;
        int diff = k;
        int total = k;

        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (k - 1) * total;
            total = same + diff;
        }
        return total;
    }
}