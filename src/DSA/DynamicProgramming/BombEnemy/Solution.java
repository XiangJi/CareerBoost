package DSA.DynamicProgramming.BombEnemy;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall
 since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.
 Example:
 For the given grid
 0 E 0 0
 E 0 W E
 0 E 0 0
 return 3. (Placing a bomb at (1,1) kills 3 enemies)
 for(i)
    for(j) {
        j
 }
 1,遍历
 2,扫描当前行 ：i 不变 j rowCount 用来记录到下一个墙之前的敌人个数,可以算出这一层我可以炸死多少人
 3,扫描当前列 ：j 不变 i （colCount[]） 其中colCnt[j]表示第j列到下一个墙之前的敌人个数
 一个1d一个2d是因为遍历方式是按row and col便利的
 time : O(m * n)
 space : O(n)

 G 很重要这题
 * @param grid
 * @return
 */

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0; // reset row count
                    /*
                     * 如果当前位置是开头一个或者上面一个是墙壁，我们开始从当前位置向下
                     * 遍历，遍历到末尾或者墙的位置停止，计算敌人个数
                     */
                    //行扫 W后面从新扫描
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowCount += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                // 列方向同理
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCount[j] = 0; // 列扫 W后面从新扫描
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colCount[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, colCount[j] + rowCount);
                }
            }
        }
        return res;
    }
}