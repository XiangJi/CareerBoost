package DSA.TwoPointers.ReverseVowelsofaString;

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
        	return s;
        }
        
        int start = 0;
        int end = s.length() - 1;
        char[] result = s.toCharArray();
        while (start < end) {
        	if (isVowel(result[start]) && isVowel(result[end])) {
        		char temp = result[start];
        		result[start] = result[end];
        		result[end] = temp;
        		start++;
        		end--;
        	} else if (isVowel(result[start])) {
        		end--;
        	} else if (isVowel(result[end])) {
        		start++;
        	} else {
        		start++;
        		end--;
        	}
        }
        return String.valueOf(result);
    }
    
    
    // This can be improved by hashset or vowels.indexOf(xxx) == -1
    private static boolean isVowel(char c) {
    	if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
    			c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	//test
    	Solution instance = new Solution();
    	System.out.println(instance.reverseVowels("leetcode"));
    }
}