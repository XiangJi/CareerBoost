package DSA.String.EncodeandDecodeStrings;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param strs a list of strings
     * @return encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // Write your code here
        StringBuilder ans = new StringBuilder();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (c == ':') {                  // : itself
                    ans.append("::");
                } else {                         //ordinary character
                    ans.append(c);
                }
            }
            ans.append(":;");                    // ; connector
        }
        return ans.toString();
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        char[] sc = str.toCharArray();
        StringBuilder item = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (sc[i] == ':') {                  //escape
                if (sc[i + 1] == ';') {          // ; connector
                    ans.add(item.toString());
                    item = new StringBuilder();
                    i += 2;
                } else {                         // : itself
                    item.append(sc[i + 1]);
                    i += 2;
                }
            } else {                             //ordinary character
                item.append(sc[i]);
                i += 1;
            }
        }
        return ans;
    }
}