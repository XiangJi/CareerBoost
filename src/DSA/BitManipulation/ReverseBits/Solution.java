package DSA.BitManipulation.ReverseBits;
/*
 * Reverse bits of a given 32 bits unsigned integer.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = (reversed << 1) | (n & 1); // 每次取末尾
            n >>= 1;
        }
        return reversed;
    }
}