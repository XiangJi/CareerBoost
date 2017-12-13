package DSA.BitManipulation.HammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        //What does come to your mind first when you see this sentence "corresponding bits are different"? Yes, XOR
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}