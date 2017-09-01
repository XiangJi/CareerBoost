package DSA.String.DetectCapital;

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        if (allCap(word) || allNonCap(word) || OnlyFirstCap(word)) {
            return true;
        }
        return false;
    }
    
    private boolean allCap(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
                return false;
            }
        }
        return true;
    }
    
    private boolean allNonCap(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }
    
    private boolean OnlyFirstCap(String word) {
        if (word.charAt(0) < 'A' || word.charAt(0) > 'Z') {
            return false;
        }
        
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }
}