package DSA.Math.ExcelSheetColumnTitle;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= 0) {
            return sb.toString();
        }
        while (n > 0) {
            n--;
            char temp = (char) ('A' + n % 26);
            n /= 26;
            sb.insert(0, temp);
        }
        return sb.toString();
    }
}