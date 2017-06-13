package DSA.HashTable.FindtheDifference;

// t has one more letter
public class Solution {
    // XOR
    public char findTheDifference(String s, String t) {
        
        if (s == null) {
            return t.charAt(0);
        }
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        
        for (int j = 0; j < s.length(); j++) {
            map[s.charAt(j)]--;
        }
        char result = 'a';
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                result = (char) i;
            }
        }
        
        return result;
    }
    
    public char findTheDifference2(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
    
    public char findTheDifference3(String s, String t) {
        int charCode = t.charAt(s.length());
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
    }
    
    
    
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        
        Solution instance = new Solution();
        System.out.print(instance.findTheDifference(s, t));
                
    }
}
