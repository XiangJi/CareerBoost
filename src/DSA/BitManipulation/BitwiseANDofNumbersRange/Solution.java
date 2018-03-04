package DSA.BitManipulation.BitwiseANDofNumbersRange;

/*
 * bit wise & between m and n
 * The idea is very simple:

find the left common part, find the law
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    int c = 0;
    while(m != n){
        m >>= 1;
        n >>= 1;
        ++c;
    }
    return n << c;
    }
}

