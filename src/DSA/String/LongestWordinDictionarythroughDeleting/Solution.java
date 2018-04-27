package DSA.String.LongestWordinDictionarythroughDeleting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.

这道题给了我们一个字符串，和一个字典，让我们找到字典中最长的一个单词，
这个单词可以通过给定单词通过删除某些字符得到。由于只能删除某些字符，并不能重新排序，
所以我们不能通过统计字符出现个数的方法来判断是否能得到该单词，而是只能老老实实的按顺序遍历每一个字符。我们可以给字典排序，通过重写comparator来实现按长度由大到小来排，如果长度相等的就按字母顺序来排。然后我们开始遍历每一个单词，用一个变量i来记录单词中的某个字母的位置，我们遍历给定字符串，如果遍历到单词中的某个字母来，i自增1，如果没有，就继续往下遍历。这样如果最后i和单词长度相等，说明单词中的所有字母都按顺序出现在了字符串s中，
由于字典中的单词已经按要求排过序了，所以第一个通过验证的单词一定是正确答案，我们直接返回当前单词即可，
 */
class Solution {
public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            public int compare(String a,String b){
                if (a.length() == b.length()) return a.compareTo(b);
                return b.length() - a.length();
          }}
        );
        // check subsequence 
        for (String str : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < str.length() && c == str.charAt(i)) {
                    i++;
                }
            }
            if (i == str.length()) return str;
        }
        return "";
    }
};
