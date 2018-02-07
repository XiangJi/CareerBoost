package DSA.Misc.NumberofIslands;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

DFS, BFS, Union find
 */

public class Solution {

    // DFS (Flood Fill algorithm)
    O（mn）
    private int m, n;
    public int numIslands(char[][] grid) {
        int result = 0;
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        // exsit condition
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        // dfs operations
        grid[i][j] = '0';
        // recursion
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    // BFS
    //O(mn)
    public int numIslands2(char[][] grid) {
        int result = 0;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        // trick for transfer 2D to 1D
        // 转换的时候从上往下数，公式为行数 * 每列个数n + 列数
        int code = x * n + y;
        queue.offer(code);

        while(!queue.isEmpty()) {
            code = queue.poll();
            int i = code / n;
            int j = code % n;

            // up
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer(((i - 1) * n) + j);
                grid[i - 1][j] = '0';
            }
            // down
            if (i < m - 1 && grid[i + 1][j] == '1') {
                queue.offer(((i + 1) * n) + j);
                grid[i + 1][j] = '0';
            }

            // left
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * n + j - 1);
                grid[i][j - 1] = '0';
            }
            // right
            if (j < n - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * n + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    // Union-Find: Disjoint-set
}