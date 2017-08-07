package DSA.BitManipulation.SingleNumberIII;

/**
 *
 *  The two numbers that appear only once must differ at some bit, this is how we can distinguish between them. Otherwise, they will be one of the duplicate numbers.

One important point is that by XORing all the numbers, we actually get the XOR of the
two target numbers (because XORing two duplicate numbers always results in 0). Consider the XOR result of the two target numbers; if some bit of the XOR result is 1, it means that the two target numbers differ at that location.

Let’s say the at the ith bit, the two desired numbers differ from each other.
which means one number has bit i equaling: 0, the other number has bit i equaling 1.

Thus, all the numbers can be partitioned into two groups according to their bits at location i.
the first group consists of all numbers whose bits at i is 0.
the second group consists of all numbers whose bits at i is 1.

Notice that, if a duplicate number has bit i as 0, then, two copies of it
 will belong to the first group. Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.

by XoRing all numbers in the first group, we can get the first number.
by XoRing all numbers in the second group, we can get the second number.
 * @author xiangji
 *
 */
public class Solution {
    public int[] singleNumber(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        // find the last 1; which means different.
        int lastBit = xor - (xor & (xor - 1)); // remember
        int group0 = 0;
        int group1 = 0;
        for (int i = 0; i < A.length; i++) {
                if ((lastBit & A[i]) == 0) {
                        group0 ^= A[i];
                } else {
                        group1 ^= A[i];
                }
        }
        // make sure, same number in the same group
        int[] result = new int[2];
        result[0] = group0;
        result[1] = group1;
        return result;
    }
}
