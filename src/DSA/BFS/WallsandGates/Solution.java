package DSA.BFS.WallsandGates;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  
  BFS
  多源单终点问题  --> 单源多终点问题
  0是注水口 -1是平原  INF是盆地
  这是一个多源多终点问题，多个原点同是注水 看谁流的快
  这相当于一个超级源点点dummy -1 时刻 连接每个点 distance为1, 下面没用用dummy源，直接0时刻普通源全部进队
  多源多中 --> 单源多种
  corner case 不能到的地方还是INF BFS就是这样的
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        final int INF = 2147483647;
        
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }
        
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        
        while(!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int i = 0; i < 4; i++) {
                // new coordinate
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n
                        && rooms[nx][ny] == INF) {
                    qx.offer(nx);
                    qy.offer(ny);
                    rooms[nx][ny] = rooms[cx][cy] + 1;
                }
            }
        }
    }
}
