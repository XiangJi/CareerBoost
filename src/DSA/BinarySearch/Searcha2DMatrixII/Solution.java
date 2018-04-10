package DSA.BinarySearch.Searcha2DMatrixII;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


search from the left bottom to right top
O(N+M) solution:Search Space Reduction prune

 */

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int  i = matrix.length - 1;
        int j = 0;
        int ans = 0;
        while ( i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j]) {
                ans++;
                i--;
                j++;
                continue;
            }
            if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return ans;
    }
    
    public boolean searchMatrixLeetCode(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}