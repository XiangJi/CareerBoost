package DSA.HashTable.IsomorphicStrings;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> mapOne = new HashMap<Character, Character>();
        HashMap<Character, Character> mapTwo = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapOne.containsKey(c1)) {
                if (mapOne.get(c1) != c2) {
                    return false;
                }
            }
            if (mapTwo.containsKey(c2)) {
                if (mapTwo.get(c2) != c1) {
                    return false;
                }
            }
            mapOne.put(c1, c2);
            mapTwo.put(c2, c1);
        }
        return true;
    }
}