package DSA.String.ReverseWordsinaStringII;

/*
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

 */
public class Solution {
    // my idea, just two pointers
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int start = 0;
        int end;
        // find the word and reverse it
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ' || i == s.length - 1) {
                end = i == s.length - 1 ? i : i - 1;
                reverse(s, start, end);
                start = i + 1;
            }
        }
        
        reverse(s, 0, s.length - 1);
    }
}