package DSA.String.LengthofLastWord;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 */
public class Solution {
    public int lengthOfLastWord(String s) {

        String[] array = s.split(" ");
        if (array.length==0)  {
            return 0;
        } else {
            return array[array.length - 1].length();
        }
    }

    public int lengthOfLastWordII(String s) {
        if (s == null || s.length() == 0) {
                return 0;
        }
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') {
                tail--;
        }
        int start = tail;
        while (start >= 0 && s.charAt(start) != ' ') {
                start --;
        }
        return tail - start;
    }
}
