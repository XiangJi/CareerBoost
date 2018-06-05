package DSA.Math.NumberOfCornerRectangles;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.



Example 1:

Input: grid =
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].


Example 2:

Input: grid =
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.


Example 3:

Input: grid =
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.

BF: 如果暴力穷举
R * (R - 1) * C * (C - 1)

用dp的思想
每加入新的一行，会新加多少个矩形？
于新行的每对1（记为cur_row[i]和cur_row[j]），新加矩形个数，是之前行row[i]= row[j] = 1出现的次数！

对于新行的每对1，例如cur_row[i]和cur_row[j]，最终结果加上count[i, j]，然后count[i, j]自增。


R * C ^ 2 降一维
S: C ^ 2 in the map
最数学优解太复杂 不记了
 */
public class Solution {
    public int countCornerRectangles(int[][] grid) {
        Map<Integer, Integer> count = new HashMap<>(); // store <i, j> -> count
        int ans = 0;
        for (int[] row : grid) {
            for (int c1 = 0; c1 < row.length; c1++)
                if (row[c1] == 1) {
                    for (int c2 = c1 + 1; c2 < row.length; c2++)
                        if (row[c2] == 1) { // i = j = 1
                            int pos = c1 * 200 + c2;
                            int c = count.getOrDefault(pos, 0);
                            ans += c;
                            count.put(pos, c + 1);
                        }
                }
        }
        return ans;
    }
}