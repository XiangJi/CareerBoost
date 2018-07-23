package DSA.Array.GameofLife;

 /**
     * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
     Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     Any live cell with two or three live neighbors lives on to the next generation.
     Any live cell with more than three live neighbors dies, as if by over-population..
     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     Write a function to compute the next state (after one update) of the board given its current state.
     time : O(m * n)
     space : O(1)
     * @param board
     * G 实现题 用运算的思想来保持之前一位
     * 面经简化版
     * 已知如果一个黑色棋子周围都是白棋子，则该棋子dead, 否则则alive,
     * 给定一个棋子的位置，求问该棋子是live or dead. Follow up：如果给定的是list of position会怎么样
     *
     *类似风格的题目 set matrix zero/bomy eneny
     */

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbor(board, i, j);
                /*
                 * 我们怎么知道其未更新的状态呢，我们可以使用状态机转换：

                                        状态0： 死细胞转为死细胞

                                        状态1： 活细胞转为活细胞

                                        状态2： 活细胞转为死细胞

                                        状态3： 死细胞转为活细胞
                                        最后我们对所有状态对2取余 或者>>1
                 */
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }
                } else if (count == 3) {
                    board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int countNeighbor(int[][] board, int i, int j) {
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j) continue;
                if ((board[row][col] & 1) == 1) count++;
            }
        }
        return count;
    }

}