package DSA.DynamicProgramming.UniquePathsII;
/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
                return 0;
        }

        int m = obstacleGrid.length; // rows
        int n = obstacleGrid[0].length;
        int[][] pathNum = new int[m][n];

        //state initialization
        for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] != 1) {
                        pathNum[0][i] = 1;
                } else {
                        break;
                }
        }

        for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] != 1) {
                        pathNum[i][0] = 1;
                } else {
                        break;
                }
        }

        for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                        if (obstacleGrid[i][j] != 1) {
                                pathNum[i][j] = pathNum[i][j - 1] + pathNum[i - 1][j];
                        } else {
                                pathNum[i][j] = 0;
                        }
                }
        }

        return pathNum[m - 1][n - 1];

    }
}