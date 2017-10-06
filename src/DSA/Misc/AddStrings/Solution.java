package DSA.Misc.AddStrings;

// Given two non-negative
// integers num1 and num2 represented as string, return the sum of num1 and num2.
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            // consider run out of number case
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}