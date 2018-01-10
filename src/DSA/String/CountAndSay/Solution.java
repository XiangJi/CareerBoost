package DSA.String.CountAndSay;

/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

brute force simulation
 */
public class Solution {
    public String countAndSay(int n) {
        String oldString = "1";
        for (int i = 0; i < n - 1; i++) {
                StringBuilder sb = new StringBuilder();
                char[] oldChars = oldString.toCharArray();

                for (int j = 0; j < oldChars.length; j++) {
                        int counter = 1;
                        while((j + 1) < oldChars.length && oldChars[j] == oldChars[j + 1]) {
                                counter++;
                                j++;
                        }
                        sb.append(String.valueOf(counter) + String.valueOf(oldChars[j]));

                }
                oldString = sb.toString();
        }
        return oldString;
    }
}