 package DSA.DynamicProgramming.KnightProbabilityinChessboard;
/*
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.

Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.

用dp count ways
dp[k][i][j] = sigma(dp[k - 1] [x][y]) 累计之间位置的
k这一层可以直接用滚动数组优化掉，另外2D不停靠swap覆盖就行了

O（n ^2 * k）
O(n ^2)
 */
public class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dp = new int[N][N]; // 这边最好用double存
        dp[r][c] = 1;
        int[][] dirs = {{1, 2}, {1,-2}, {2, -1}, {2, 1}, {-1, 2}, {-1,-2}, {-2,1}, {-2, -1}};
        for (int k = 0; k < K; k++) {
            int[][] dp2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int m = 0; m < 8; m++) {
                        int x = i + dirs[m][0];
                        int y = j + dirs[m][1];
                        if (x < 0 || y < 0 || x >= N || y >= N) {
                            continue;
                        }
                        dp2[x][y] += dp[i][j];
                    }
                }
            }
            dp = dp2;
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += dp[i][j];
            }
        }
        return count / (double) (Math.pow(8, K));
    }
}
