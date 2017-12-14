package DSA.String.LicenseKeyFormatting;

/*
 * Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part
has 4 characters.
Note that the two extra dashes are not needed and can be removed.
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        // Algorithm: use sb to build from the end, then reverse, upper case
        // StringBuilder > StringBuffer(thread safe but slow, used in multithread environment) > String
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length()- 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {

                if (count < K) {
                    sb.append(S.charAt(i));
                    count++;
                } else {
                    count = 1;
                    sb.append("-" + S.charAt(i));
                }
            }
        }
        // only sb can reverse! String does not have the method
        return sb.reverse().toString().toUpperCase();

    }
}