package DSA.HashTable.WordPattern;

import java.util.HashMap;

public class Solution {
    // duplicate problem with isomorphicStrings
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }

        HashMap<Character, String> mapOne = new HashMap<Character, String>();
        HashMap<String, Character> mapTwo = new HashMap<String, Character>();

        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            String c2 = array[i];
            if (mapOne.containsKey(c1)) {
                if (!mapOne.get(c1).equals(c2) ) {
                    return false;
                }
            }
            if (mapTwo.containsKey(c2)) {
                if (!mapTwo.get(c2).equals(c1)) {
                    return false;
                }
            }
            mapOne.put(c1, c2);
            mapTwo.put(c2, c1);
        }

        return true;
    }
}