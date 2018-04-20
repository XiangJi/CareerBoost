package DSA.Graph.TheMaze;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

DFS and BFS all works
 */
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            if (curPos[0] == destination[0] && curPos[1] == destination[1]) {
                return true;
            }
            // try four direction until it hits the wall
            for (int direction = 0; direction < 4; direction++) {
                int nx = curPos[0], ny = curPos[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[direction];
                    ny += dy[direction];
                }

                //back one step
                nx -= dx[direction];
                ny -= dy[direction];

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    public boolean hasPathII(int[][] maze, int[] start, int[] destination) {
        // DFS
        if (maze == null || start == null || destination == null) {
            return false;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPath(maze, start, destination, visited);
    }
    private boolean hasPath(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        int y = start[0];
        int x = start[1];
        if (visited[y][x]) return false;
        visited[y][x] = true;
        if (x == dest[1] && y == dest[0]) {
            return true;
        }
        // left
        if (x > 0 && maze[y][x-1] != 1) {
            int i = x - 1;
            while (i > 0 && maze[y][i-1] != 1) i--;
            if (hasPath(maze, new int[]{y, i}, dest, visited)) return true;
        }
        //right
        if (x < maze[0].length - 1 && maze[y][x+1] != 1) {
            int i = x + 1;
            while (i < maze[0].length-1 && maze[y][i+1] != 1)  i++;
            if (hasPath(maze, new int[]{y, i}, dest, visited)) return true;
        }
        //up
        if (y > 0 && maze[y-1][x] != 1) {
            int i = y - 1;
            while (i > 0 && maze[i-1][x] != 1) i--;
            if (hasPath(maze, new int[]{i, x}, dest, visited)) return true;
        }
        //down
        if (y < maze.length - 1 && maze[y+1][x] != 1) {
            int i = y + 1;
            while (i < maze.length-1 && maze[i+1][x] != 1) i++;
            if (hasPath(maze, new int[]{i, x}, dest, visited)) return true;
        }
        return false;
    }
}
