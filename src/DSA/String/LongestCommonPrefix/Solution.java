package DSA.String.LongestCommonPrefix;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 以第一个为base 逐个比较
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}