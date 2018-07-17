package DSA.BinarySearch.SqrtX;

/*
 * Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer
 */
public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    // 九章的模板是万能的 最后再来处理start end结果
    public int mySqrt(int x) {
        // write your code here
        long left = 0;
        long right = x;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (x < mid * mid) {
                right = mid; // Binary search, but trick her.
            } else {
                left = mid;
            }
        }
        if (right * right <= x) {
            return (int) right;
        }
        return (int) left;
    }
}