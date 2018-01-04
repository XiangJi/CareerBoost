package DSA.Math.HappyNumber;

import java.util.HashSet;

/*
 * Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class Solution {
    // just use hash to check if dup
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n > 0) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return false;
            }
            n = nextHappy(n);
            if (n == 1) {
                return true;
            }
            
        }
        return false;
    }
    
    private int nextHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
