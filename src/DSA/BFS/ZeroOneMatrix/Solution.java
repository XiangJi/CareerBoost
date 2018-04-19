package DSA.BFS.ZeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2:
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.

Like walls and gates
多源点多终点 变成单源多终点问题 所有0同时注水,最先碰到就算

Doing a BFS from each ZERO seems more of a DFS approach than a BFS to me.
 The point of BFS is to process all possibilities (states) reachable from each
  level in a progressive manner. Doing a BFS from each zero will not ensure
 this and act more as a DFS from each zero rather than a BFS as a whole.
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        // put coordinates
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int i = 0; i < 4; i++) {
                // new coordinate
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n
                        && matrix[nx][ny] >= matrix[cx][cy] + 1) {
                    matrix[nx][ny] = matrix[cx][cy] + 1;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }

        return matrix;
    }
}