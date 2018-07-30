package DSA.Graph.NumberofIslands;

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
    //O（mn）
    private int m, n;
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
            
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    // BFS
    //O(mn)
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int numIslandsII(char[][] grid) {
        int res = 0;
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void bfs(char[][] grid, int x, int y) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(x);
        qy.offer(y);
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            // four direction
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                    qx.offer(nx);
                    qy.offer(ny);
                    grid[nx][ny] = '0';
                }
            }
        }
    }

    // Union-Find: Disjoint-set
}