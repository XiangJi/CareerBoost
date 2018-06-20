package DSA.Graph.TheMazeII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination.
 *
 * Follow up: shortest path, dijkstra algorithm,
 * Dijkstra allows assigning distances other than 1 for each step. For example,
 *  in routing the distances (or weights) could be assigned by speed, cost, preference,
 *   etc. The algorithm then
 * gives you the shortest path from your source to every node in the traversed graph.
 * DFS, BFS, Dijkstra
 *
 * 最短距离用BFS就够了 帅帅帅
 * 建立一个到起点的最短距离矩阵 在BFS的时候不断更新
 */
public class Solution {
    //BFS
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
         int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    /*
     * From the current position, we determine the number of steps required to reach all the positions possible travelling from the current position(in all the four directions possible till hitting a wall/boundary). If it is possible to reach any position through the current route with a lesser number of steps than the earlier routes considered, we update the corresponding distancedistance entry. We continue the same process for the other directions as well for the current position.

In order to determine the current node, we make use of minDistance function, in which we traverse over the whole distancedistance array and find out an unvisited node at the shortest distance from the startstart node.

At the end, the entry in distancedistance array corresponding to the destinationdestination position gives the required minimum number of steps. If the destination can't be reached, the corresponding entry will contain
     */
}
