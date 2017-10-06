package DSA.String.ReverseString;

public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int i = 0;
        int j =s.length() - 1;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(array);
    }
}
