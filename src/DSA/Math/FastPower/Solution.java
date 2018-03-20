package DSA.Math.FastPower;

/*
 * Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.

T: O(logN)
S: O(logN) / O(1)
 */
public class Solution {
    // fast power recursive solution
    public double myPow(double x, int n) {
        // brute force, just O(n)
        // Use binary search. DC actually
        // exit condition
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double product = x;
        product = power(product, n / 2);

        if (n % 2 == 0) {
            product = product * product;
        }
        if (n % 2 == 1) {
            product = product * product * x;
        }
        return product;
    }

    public double myPowII(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * x;
            }
            x *= x; // half product
        }
        return ans;
    }
}