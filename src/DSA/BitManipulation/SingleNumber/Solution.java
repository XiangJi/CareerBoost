package DSA.BitManipulation.SingleNumber;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}