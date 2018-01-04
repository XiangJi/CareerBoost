package DSA.BitManipulation.MissingNumber;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n
 * , find the one that is missing from the array.
 */
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