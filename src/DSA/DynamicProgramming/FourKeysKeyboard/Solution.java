package DSA.DynamicProgramming.FourKeysKeyboard;

/*
 * Imagine you have a special keyboard with the following keys:

Key 1: (A): Print one 'A' on screen.

Key 2: (Ctrl-A): Select the whole screen.

Key 3: (Ctrl-C): Copy selection to buffer.

Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.

Example 1:
Input: N = 3
Output: 3
Explanation:
We can at most get 3 A's on screen by pressing following key sequence:
A, A, A
Example 2:
Input: N = 7
Output: 9
Explanation:
We can at most get 9 A's on screen by pressing following key sequence:
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
Note:
1 <= N <= 50
Answers will be in the range of 32-bit signed integer.

Explanation

We either press 'A', or press 'CTRL+A', 'CTRL+C', and some number of 'CTRL+V's. Thus, in the context of making N keypresses to write the letter 'A' M times, there are only two types of moves:

Add (1 keypress): Add 1 to M.
Multiply (k+1 keypresses): Multiply M by k, where k >= 2.
In the following explanations, we will reference these as moves.


 */
public class Solution {
    /*
     * 们可以分析题目中的例子可以发现，N步最少都能打印N个A出来，
     * 因为我们可以每步都是打印A。那么能超过N的情况肯定就是使用了复制粘贴，
     * 这里由于全选和复制要占用两步，所以能增加A的个数的操作其实只有N-2步，
     * 那么我们如何确定打印几个A，剩下都是粘贴呢，其实是个trade off，A打印的太多或太少，
     * 都不会得到最大结果，所以打印A和粘贴的次数要接近，最简单的方法就是遍历所有的情况然后取最大值，
     * 打印A的次数在[1, N-3]之间，粘贴的次数为N-2-i，加上打印出的部分，就是N-1-i了
     *
     */
    // search
    public int maxA(int n) {
        int max = n;
        for (int i = 1; i <= n - 3; i++)
            max = Math.max(max, maxA(i) * (n - i - 1));
        return max;
    }

    // DP
    public int maxB(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }

}
