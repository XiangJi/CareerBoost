package DSA.BinarySearch.SearchinRotatedSortedArray;

public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, upper half
                if (A[mid] >= target
                        && A[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, lower half
                if (A[mid] <= target && A[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } // 2rd situation
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    } // search rotated array function
}