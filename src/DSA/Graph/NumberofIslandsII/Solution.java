package DSA.Graph.NumberofIslandsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a
 * land. Given a list of positions to operate, count the number of islands after each addLand
 * operation. An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all surrounded
 * by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents
 land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
yes just use regular union find lg (mn) * k

Just like number of componets, just 2D matrix, and need called multiple times
 */
public class Solution {
int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] pair : positions) {
            // 2D converted to 1D, initialization
            int position = n * pair[0] + pair[1];
            roots[position] = position; // initialization root as it self
            count++;

            for (int[] dir : dirs) {
                // up down left right, turn to 2D
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];
                // turn back to 1D
                int curPos = n * x + y;
                //corner case
                if (x < 0 || x >= m || y < 0 || y >= n || roots[curPos] == -1) {
                    continue;
                }
                int anoIsland = find(roots, curPos);
                if (position != anoIsland) {
                    roots[position] = anoIsland; // connect
                    position = anoIsland;
                    count--; // minus 1
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) { // this condition is different, because init is not -1
            i = roots[i];
        }
        return i;
    }
}
