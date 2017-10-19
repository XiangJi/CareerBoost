package DSA.HashTable.StrobogrammaticNumber;

import java.util.HashMap;

/*
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        int left = 0;
        int right = num.length() - 1;
        
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || !map.containsKey(num.charAt(right))) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}