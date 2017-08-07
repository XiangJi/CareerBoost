package DSA.BitManipulation.SingleNumberII;

/*
 * The usual bit manipulation code is bit hard to get and replicate. I like to think about the number in 32 bits
 * and just count how many 1s are there in each bit, and sum %= 3 will clear it once it reaches 3. After running for all the numbers
 * for each bit, if we have a 1, then that 1 belongs to the single number, we can simply move it back to its spot by doing ans |= sum << i;
 * This has complexity of O(32n), which is essentially O(n) and very easy to think and implement.
 * Plus, you get a general solution for any times of occurrence. Say all the numbers have 5 times, just do sum %= 5.
 */
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
                return -1;
        }

        int result = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
                // calculate each bit by traverse the array one time
                // start from the last bit
                for (int j = 0; j < A.length; j++) {
                        bits[i] += (A[j] >> i) & 1;
                        bits[i] %= 3;
                }
                result |= bits[i] << i; // build every bit
        }
        return result;
    }
}