package DSA.Math.SqrtX;

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
    public int mySqrt(int x) {
        // write your code here
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (x < mid * mid) {
                right = mid - 1; // Binary search, but trick her.
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}