package DSA.BitManipulation.PowerofThree;

public class Solution {
    // brute force
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 ==0) {
            n = n / 3;
        }
        return n == 1;
    }
    
    // fastest: biggest power of 3 less than int % n return ( n>0 &&  1162261467%n==0);
}
