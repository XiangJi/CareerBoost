package DSA.Math.FactorialTrailingZeroes;

/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * Your solution should be in logarithmic time complexity.
 *
 *
 * 10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros is the minimum of the number of 2 and the number of 5.
 * Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by the number of 5.
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
            count += n / 5;
            n /= 5; // for next loop, count 25..125...N is not changed, 5 goes down
        }
        return count;
    }
}