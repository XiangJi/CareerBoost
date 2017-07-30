package DSA.HashTable.PalindromePermutation;

// brute force, use hashmap to store the string count, odd count can not be more than 1
// Single pass approach: use a int count to store the odd number on flight, update it always then determine in the end
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        int[] map = new int[128];
        int oddCount = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0) {
                oddCount--;
            } else {
                oddCount++;
            }
        }
        
        return oddCount <= 1;
    }
}