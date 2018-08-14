package DSA.DynamicProgramming.DeleteOperationforTwoStrings;

/*
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.

To make them identical, just find the longest common subsequence. The rest of the characters have to be deleted from the both the strings, which does not belong to longest common subsequence.

LCS 问题被用于字符串比较 git diff

2D DP
 */
class Solution {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
            }
        }
        int val = f[n][m];
        return m + n - 2 * val;
    }
}