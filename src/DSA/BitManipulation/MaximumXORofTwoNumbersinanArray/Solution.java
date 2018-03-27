package DSA.BitManipulation.MaximumXORofTwoNumbersinanArray;

import java.util.HashSet;

/*
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

BF: Native
Use bit manipulation property
不进位加法-异或
a ^ b = c, a ^ c = b, b ^ c = a
Find the highest bit from left
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i; // every add 1 from left
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            // get the current possible prefix max: temp, a ^ temp = b -> a ^ b = temp
            int temp = max | (1 << i);
            for (int n : set) {
                if (set.contains(n ^ temp)) {
                    max = temp;
                    break; // found it!
                }
            }
        }
        return max;
    }
}