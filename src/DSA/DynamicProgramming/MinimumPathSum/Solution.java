package DSA.DynamicProgramming.MinimumPathSum;

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class Solution {
    // use grid as name, harder to spell wrong
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length; // 行数
        int n = grid[0].length; // 列数
        int[][] sum = new int[m][n];
        
        // State initialization
        sum[0][0] = grid[0][0];
        
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i]; // first row
        }
        
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        
        //function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) { //i j最后分清楚
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        
        //final answer
        return sum[m - 1][n - 1];
    }
}