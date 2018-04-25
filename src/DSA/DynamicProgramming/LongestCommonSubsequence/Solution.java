package DSA.DynamicProgramming.LongestCommonSubsequence;
/*
 * Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

 */
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = B.length();
        // two dimensions , the first row and column
        // 学会推理，不要背诵
        int[][] f = new int[m + 2][n + 2]; // why add 2?
//      for (int i = 0; i < m; i++) {
//          f[i][0] = 0;
//      }
//      for (int j = 0; j < n; j++) {
//          f[0][j] = 0;
//      }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                if (A.charAt(i) == B.charAt(j)) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
            }
        }
        return f[m][n];
    }
}