package DSA.Array.LonelyPixelTwo;

/*
 * Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels located at some specific row R and column C that align with all the following rules:

Row R and column C both contain exactly N black pixels.
For all rows that have a black pixel at column C, they should be exactly the same as row R
The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

Example:
Input:
[['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'W', 'B', 'W', 'B', 'W']]

N = 3
Output: 6
Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
        0    1    2    3    4    5         column index
0    [['W', 'B', 'W', 'B', 'B', 'W'],
1     ['W', 'B', 'W', 'B', 'B', 'W'],
2     ['W', 'B', 'W', 'B', 'B', 'W'],
3     ['W', 'W', 'B', 'W', 'B', 'W']]
row index

Take 'B' at row R = 0 and column C = 1 as an example:
Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.


我们还是要统计每一行每一列的黑像素的个数，
而且由于条件二中要比较各行之间是否相等，如果一个字符一个字符的比较写起来比较麻烦，
我们可以用个trick，把每行的字符连起来，形成一个字符串，然后直接比较两个字符串是否相等会简单很多。
然后我们遍历每一行和每一列，如果某行和某列的黑像素刚好均为N，我们遍历该列的所有黑像素，如果其所在行均相等，
则说明该列的所有黑像素均为孤独的像素，将个数加入结果res中，然后将该行的黑像素统计个数清零，以免重复运算，
这样我们就可以求出所有的孤独的像素了
 */
public class Solution {
    public int findBlackPixel(char[][] board, int N) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0) {
            return count;
        }
        int m = board.length;
        int n = board[0].length;

        String[] rows = new String[m];
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += board[i][j];
                if (board[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowCount[i] == N && colCount[j] == N) {
                    for (k = 0; k < m; k++) {
                        if (board[k][j] == 'B') { // attention board[k][j]
                            if (!rows[i].equals(rows[k])) {
                                break;
                            }
                        }
                    }
                    if (k == m) {
                        count += colCount[j];
                        colCount[j] = 0;
                    }

                }
            }
        }
        return count;
    }
}
