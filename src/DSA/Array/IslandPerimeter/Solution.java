package DSA.Array.IslandPerimeter;
/*
 * 下面这种方法对于每个岛屿格子先默认加上四条边，然后检查其左面和上面是否有岛屿格子，有的话分别减去两条边，这样也能得到正确的结果
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        neighbours++; // count right neighbours
                }
            }
        }
        // math
        return islands * 4 - neighbours * 2;
    }
}