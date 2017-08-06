package DSA.BitManipulation.MissingNumber;

public class Solution {
    //brute force, find the total, then minus
    public int missingNumber(int[] nums) {
        int result = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        result ^= i;
        return result;
    }
}