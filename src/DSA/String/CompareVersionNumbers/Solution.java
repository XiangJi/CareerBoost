package DSA.String.CompareVersionNumbers;
/*
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

http://blog.csdn.net/shenzhennba/article/details/8086110
Java中的split函数的用法
想用 | 竖线去分割某字符，因 | 本身是正则表达式中的一部分，所以需要 \ 去转义，
因转义使用 \, 而这个 \ 正好也是正则表达式的字符，所以还得用一个 \ , 所以需要两个 \\

 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] one = version1.split("\\."); // split return an array of String
        String[] two = version2.split("\\.");
        int m = one.length;
        int n = two.length;
        int compareTimes = Math.max(m, n);
        for (int i = 0; i < compareTimes; i++) {
            int v1 = i < m ? Integer.parseInt(one[i]) : 0;
            int v2 = i < n ? Integer.parseInt(two[i]) : 0;
            
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
