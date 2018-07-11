package DSA.Array.LongestLineofConsecutiveOneinMatrix;

/*
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3

矩阵操作

N ^ 2
 * 对于一个mxn的矩阵，对角线和逆对角线的排数都是m+n-1个，
 * 难点在于我们要确定每一排上的数字的坐标，如果i是从0到m+n-1之间遍历，
 * j是在i到0之间遍历，那么对角线的数字的坐标就为(i-j, j)，逆对角线的坐标就为(m-1-i+j, j)
 *
 */
public class Solution {

    int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int res = 0;
        int m = M.length;
        int n = M[0].length;
        for (int i = 0; i < m; i++) { // Check horizontal
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    cnt++;
                    res = Math.max(res, cnt);
                }
                else cnt = 0;
            }
        }
        for (int j = 0; j < n; ++j) {
            int cnt = 0;
            for (int i = 0; i < m; ++i) { // Check vertical
                if (M[i][j] == 1) {
                    cnt++;
                    res = Math.max(res, cnt);
                }
                else cnt = 0;
            }
        }
        for (int i = 0; i < m + n - 1; ++i) {
            int cnt1 = 0, cnt2 = 0;
            for (int j = i; j >= 0; --j) {
                if (i - j < m && j < n) { // Check diagonal
                    if (M[i - j][j] == 1) res = Math.max(res, ++cnt1);
                    else cnt1 = 0;
                }
                int t = m - 1 - i + j;
                if (t >= 0 && t < m && j < n ) { // Check anti-diagonal
                    if(M[t][j] == 1) res = Math.max(res, ++cnt2);
                    else cnt2 = 0;
                }
            }
        }
        return res;
    }
};
