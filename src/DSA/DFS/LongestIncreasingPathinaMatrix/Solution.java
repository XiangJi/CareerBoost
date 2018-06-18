package DSA.DFS.LongestIncreasingPathinaMatrix;

/*
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.


DFS + memorization prune(recursive DP)

time : O(m * n)
     space : O(m * n)

cache 保存了每个点最多可以走多少次
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }
    // 传参 index m n pre
    private int dfs(int[][] matrix, int pre, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= pre) {
            return 0;
        }
        // if calculated before, no need to do it again
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        pre = matrix[i][j]; // 这个数拿来和下一层比较
        int a = dfs(matrix, pre, i - 1, j, m, n, cache) + 1; // 别忘了+1
        int b = dfs(matrix, pre, i + 1, j, m, n, cache) + 1;
        int c = dfs(matrix, pre, i, j - 1, m, n, cache) + 1;
        int d = dfs(matrix, pre, i, j + 1, m, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }
}