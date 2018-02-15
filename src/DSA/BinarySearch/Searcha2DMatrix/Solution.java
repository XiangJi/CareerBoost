package DSA.BinarySearch.Searcha2DMatrix;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 */
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rowNumber = matrix.length;
        int columnNumber = matrix[0].length;
        
        // 1. search row
        int start = 0;
        int end = rowNumber - 1;
        int mid;
        
        while (start + 1 < end) {
            mid = (start + end) / 2;
            
            if (matrix[mid][0] == target) {
                end = mid;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else if (matrix[mid][0] < target) {
                start = mid;
            }
        }
        
        int row;
        
        if (matrix[start][0] <= target && matrix[end][0] > target) {
            row = start;
        } else {
            row = end;
        }
        // 2. search column
        start = 0;
        end = columnNumber - 1;
        
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (matrix[row][mid] == target) {
                end = mid;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else if (matrix[row][mid] < target) {
                start = mid;
            }
            
        }
        
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
        
    }
}