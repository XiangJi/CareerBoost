package DSA.Math.AddDigits;

/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

a mod b = -(-a mod b)
 */

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
    // just loop
    public int addDigits2(int num) {
        while (num > 9) {
            int result = 0;
            while (num != 0) {
                result += num % 10;
                num /= 10;
            }
            num = result;
        }
        return num;
    }
    // recursive
    public int addDigits3(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum > 9) {
            return addDigits3(sum);
        }
        return sum;
    }
}