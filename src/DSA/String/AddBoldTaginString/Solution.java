package DSA.String.AddBoldTaginString;
/*
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].

G高频

思路是建一个和字符串s等长的bold布尔型数组，
表示如果该字符在单词里面就为true，那么最后我们就可以根据bold数组的真假值来添加标签了。
我们遍历字符串s中的每一个字符，把遍历到的每一个字符当作起始位置，我们都匹配一遍字典中的所有单词，如果能匹配上，我们就用i + len来
更新end，len是当前单词的长度，end表示字典中的单词在字符串s中结束的位置，那么如果i小于end，bold[i]就要赋值为true了。

最后我们更新完bold数组了，就再遍历一遍字符串s，如果bold[i]为false，直接将s[i]加入结果res中；如果bold[i]为true，
那么我们用while循环来找出所有连续为true的个数，然后在左右两端加上标签

注意start with函数
这道题是实现细节题
Shawn Gao大神牛逼！
 */
public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) { // startWith, string, offset
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) { // 注意j不能越界
                j++;
            }
            result.append("<b>" + s.substring(i, j) + "</b>"); // substring取到j的前一位
            i = j - 1; // i要归位
        }

        return result.toString();
    }
}