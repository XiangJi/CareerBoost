package DSA.HashTable.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * 
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 */
public class Solution {
    
    // O(m x n x logN)
    public List<List<String>> groupAnagrams(String[] strs) {
         if (strs.length == 0 || strs == null) {
             return new ArrayList<List<String>>();
         }
         HashMap<String, List<String>> map = new HashMap<String, List<String>>();
         
         for (String s : strs) {
             char[] array = s.toCharArray();
             Arrays.sort(array);
             String sortedString = String.valueOf(array); // static to String function
             if (!map.containsKey(sortedString)) {
                 map.put(sortedString, new ArrayList<String>());
             }
             map.get(sortedString).add(s);
         }
         
         return new ArrayList<List<String>>(map.values());
    }
    
    // use counting sort, use space to get time
    // O(m x n)
    public List<List<String>> groupAnagramsII(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String s : strs) {
            char[] array = s.toCharArray();
            // use counting sort
            int[] count = new int[26];
            for (int i = 0; i < array.length; i++) {
                count[array[i] - 'a']++;
            }
            String string = "";
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    string += count[i] + ('a' + i);
                }
            }
            
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList<String>());
            }
            map.get(string).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
   }
    
}
