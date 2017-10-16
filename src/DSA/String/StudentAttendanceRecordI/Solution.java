package DSA.String.StudentAttendanceRecordI;

/*
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more
 than one 'A' (absent) or more than two continuous 'L' (late).
 */
public class Solution {
    public boolean checkRecord(String s) {
        if (s.length() == 0) {
            return false;
        }

        int numA = 0;
        int maxL = 0;
        int tempL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                tempL++;
                maxL = Math.max(maxL, tempL);
            }
            if (s.charAt(i) == 'A') {
                numA++;
                tempL = 0;
            }
            if (s.charAt(i) == 'P') {
                tempL = 0;
            }
        }

        if (maxL > 2 || numA > 1) {
            return false;
        }
        return true;
    }
}