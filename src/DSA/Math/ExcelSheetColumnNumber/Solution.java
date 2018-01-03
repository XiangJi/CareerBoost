package DSA.Math.ExcelSheetColumnNumber;

/*
 * iven a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

 * power of N basic 进制转化
 */
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;

        for (int i = s.length() - 1, j = 0; i >= 0; i--) {
            int bit = s.charAt(i) - 'A' + 1;
            result += bit * Math.pow(26, j);
            j++;
        }
        return result;
    }

    // neat version
    public int titleToNumber2(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
          result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
      }
}