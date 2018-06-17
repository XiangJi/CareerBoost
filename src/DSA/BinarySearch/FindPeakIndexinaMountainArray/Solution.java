package DSA.BinarySearch.FindPeakIndexinaMountainArray;

// 一个确定有山峰的array找山峰
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] > A[end]) {
            return start;
        }
        return end;
    }
}