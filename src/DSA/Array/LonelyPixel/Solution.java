package DSA.Array.LonelyPixel;
/*
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.

The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

Example:
Input:
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

Output: 3
Explanation: All the three 'B's are black lonely pixels.
Note:
The range of width and height of the input 2D array is [1,500].
 */
class Solution {
    // O(mn)
    public int findLonelyPixel(char[][] board) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0) {
            return count;
        }
        int m = board.length;
        int n = board[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    if (rowCount[i] == 1 && colCount[j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}