package DSA.Math.PlusOne;

/*
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */

// if not returned yet, all the number carried, so 10000xxxx
class Solution {
    public int[] plusOne(int[] number) {
        int m = number.length;
        for (int i = m - 1; i >= 0; i--) {
            if (number[i] != 9) {
                number[i]++;
                break;
            } else {
                number[i] = 0;
            }
        }
        
        if (number[0] == 0) {
            int[] res = new int[m + 1];
            res[0] = 1;
            return res;
        }
        return number;
        
    }
}