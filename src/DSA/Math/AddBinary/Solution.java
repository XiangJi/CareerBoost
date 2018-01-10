package DSA.Math.AddBinary;
/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
                return null;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder result = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1 ) {
                int sum = carry; // the base
                if (i >= 0) {
                        sum += a.charAt(i) - '0';
                        i--;
                }

                if (j >= 0) {
                        sum += b.charAt(j) - '0';
                        j--;
                }
                carry = sum / 2;
                sum %= 2;
//              System.out.println("Sum:" + sum);
                result.insert(0, sum); // 在string的offset为0的index位置放sum

        }
        return result.toString();

    }

}