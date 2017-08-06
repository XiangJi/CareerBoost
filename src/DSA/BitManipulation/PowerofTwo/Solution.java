package DSA.BitManipulation.PowerofTwo;

// just write down the binary representation
public class Solution {
    public boolean isPowerOfTwo(int n) {
        // corner case
        if (n <= 0) {
            return false;
        }
        if ((n & ( n - 1)) == 0) {
            return true;
        }
        return false;
    }
}