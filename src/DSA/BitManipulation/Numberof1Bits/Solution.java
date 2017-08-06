package DSA.BitManipulation.Numberof1Bits;

/** In the binary representation, the least significant 11-bit in nn always 
 * corresponds to a 00-bit in n - 1n−1. Therefore, anding the two numbers nn and
 * n - 1n−1 always flips the least significant 11-bit in nn to 00, and keeps all other bits the same.
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}