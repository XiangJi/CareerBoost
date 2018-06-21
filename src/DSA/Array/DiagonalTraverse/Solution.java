package DSA.Array.DiagonalTraverse;

/*
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.

Base algorithm
初始对角线方向为右上方（偏移量：行-1, 列+1），遇到边界时转向左下方（偏移量：行+1, 列-1）

DS: k flag 1 - 1
 di dj 坐标 看坐标怎么动

向右上方移动遇到上边界时，若未达到右边界，则向右移动（偏移量：行+0，列+1），否则向下移动（偏移量：行+1，列+0）

向左下方移动遇到左边界时，若未达到下边界，则向下移动（偏移量：行+1，列+0），否则向右移动（偏移量：行+0，列+1）
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;

        int[] res = new int[m * n];

        int i= 0, j = 0, k = 1; // k is the odd even flag
        int di = 0;
        int dj = 0;
        for (int x = 0; x < m * n; x++) {
            res[x] = matrix[i][j];

            // core algorithm
            if (k > 0) {
                di = i - 1;
                dj = j + 1;
            } else {
                di = i + 1;
                dj = j - 1;
            }
            // corner case
            if (0 <= di && di < m && 0 <= dj && dj< n ) {
                i = di;
                j = dj;
            } else {
                if (k > 0) {
                    if (j + 1 < n) { // hit top
                        j++; // shift right
                    } else { // hit right
                        i++;
                    }
                } else {
                    if (i + 1 < m) { // hit left
                        i++; // shift down
                    } else {
                        j++;
                    }
                }
                k *= -1; // flip odd and even
            }

        }
        return res;

    }
    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] box  = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        test.findDiagonalOrder(box);
    }
}