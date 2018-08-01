package DSA.TwoPointers.Backspace;

/*
 * G 这半年高频面经
 * 两个输入string 有backspace代表删除一位 <
 * 比较两个string是否相同
 * 还有一种版本是char array, \b是 backspace 时间空间要求N 1
 * 解法是双指针从后面开始扫
 *
 * each list contains a sequence keyboard events typed by different users. For simplicity, lets assume the keyboard contains only alphanumeric letters and a backspace key.
 *
 * 也可以stack
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.



Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

ntuition

Let's individually build the result of each string (build(S) and build(T)), then compare if they are equal.

Algorithm

To build the result of a string build(S), we'll use a stack based approach, simulating the result of each

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}

实现类似valid abbr那题

就按这个实现
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abz<c";
        String b = "xyz<<<abc";
        Solution test = new Solution();
        System.out.println(test.backspaceCompare(a, b));

    }
}
