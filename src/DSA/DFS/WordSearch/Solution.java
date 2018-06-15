package DSA.DFS.WordSearch;
/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board, int i, int j, String word, int start) {
        if (start >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(start++)) {
            char c = board[i][j];
            board[i][j] = '#'; // avoid duplicate! nice trick
            boolean res = find(board, i + 1, j, word, start) ||
                    find(board, i - 1, j, word, start) ||
                    find(board, i, j + 1, word, start) ||
                    find(board, i, j - 1, word, start);
            board[i][j] = c; // backtrack
            return res;
        }
        return false;
    }
}
