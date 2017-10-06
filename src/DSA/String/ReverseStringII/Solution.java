package DSA.String.ReverseStringII;

/*
 * Given a string and an integer k, you need to reverse the
 * first k characters for every 2k characters counting from the
 * start of the string. If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * Access Levels
Modifier        Class   Package Subclass        World
public          Y       Y       Y       Y
protected       Y       Y       Y       N
no modifier     Y       Y       N       N
private         Y       N       N       N
 */
class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int n = array.length;
        for (int left = 0; left < array.length; left += 2 * k) {
            int i = left;
            int j = Math.min(i + k - 1, n - 1);
            while (i < j) {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(array);
    }
}