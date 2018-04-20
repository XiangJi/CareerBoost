package DSA.BFS.PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

Like surrounded regions, BFS fill from P first, mark the nodes, use hashTable
Them fill from A, BFS, if point is in the HashTable, make them into the results
we can just use matrix for hash
 */
public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
     
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int m, n;
     
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        
        // push initial edge cells to queue
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            pQueue.offer(new int[]{i, 0});
            atlantic[i][n - 1] = true;
            aQueue.offer(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            pQueue.offer(new int[]{0, j});
            atlantic[m - 1][j] = true;
            aQueue.offer(new int[]{m - 1, j});
        }
        
        // BFS to mark visited
        bfs(pacific, pQueue, matrix);
        bfs(atlantic, aQueue, matrix);
        
        // find common visited cells
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[] {i,j});
                }
            }
        }
        
        return res;
    }
    
    private void bfs(boolean[][] visited, Queue<int[]> queue, int[][] matrix) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && matrix[nx][ny] >= matrix[x][y]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
