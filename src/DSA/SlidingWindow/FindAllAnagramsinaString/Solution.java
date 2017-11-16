package DSA.SlidingWindow.FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */

    // brute force, get all the substring with length p, then compare each pair, store the value

    // optimize 1: use sliding window to store the substring hashmap

    // optimize 2: use sliding window and absValue to check if two map is the equal to each other, sliding window


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return result;
        }

        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        int[] det = new int[256];

        // initial the sliding window
        for (int i = 0; i < p.length(); i++ ) {

            det[sc[i]]++;
            det[pc[i]]--;
        }

        int absSum = 0;
        for (Integer num : det) {
            absSum += Math.abs(num);
        }
        if (absSum == 0) {
            result.add(0);
        }

        //i is the end index of substring
        for (int i = p.length(); i < s.length(); i++) {
            int r = sc[i];
            int l = sc[i - p.length()];
            // remove old delta
            absSum = absSum - Math.abs(det[r]) - Math.abs(det[l]);

            det[r]++;
            det[l]--;

            //add new delta
            absSum = absSum + Math.abs(det[r]) + Math.abs(det[l]);
            if (absSum == 0) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}