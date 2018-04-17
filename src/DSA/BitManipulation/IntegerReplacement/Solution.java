package DSA.BitManipulation.IntegerReplacement;

/*
 * Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

尽可能的多消除1
偶数直接除2
如果奇数：
如果倒数第二位是0，那么n-1消除更多1
如果是1，那么n+1消除更多1

特殊情况3 11 应该要-1
 */
public class Solution {
    // Bit manipulation
    public int integerReplacement(int n) {
        int result = 0;
        long N = n;
        while (N != 1) {
            if (N % 2 == 0) {
                N /= 2; //also N>>= 1
                result++;
            } else {
                if (N == 3) {
                    result += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
                result++;
            }

        }
        return result;
    }
    // my intuitive: using DP
    public int integerReplacementII(int n) {
        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
            } else {
                dp[i] = 1 + Math.min(1 + dp[i / 2 + 1], dp[i - 1]);
            }
        }
        return dp[n];
    }
}
