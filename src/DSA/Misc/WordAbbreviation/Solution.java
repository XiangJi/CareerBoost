package DSA.Misc.WordAbbreviation;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int length = dict.size();
        String[] result = new String[length];
        int[] prefix = new int[length];
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (int i = 0; i < length; i++) {
            prefix[i] = 1;
            result[i] = getAbbr(dict.get(i), 1);
            count.put(result[i], count.getOrDefault(result[i], 0) + 1);
        }

        while (true) {
            boolean unique = true;
            for (int i = 0; i < length; i++) {
                if (count.get(result[i]) > 1) {
                    prefix[i]++;
                    result[i] = getAbbr(dict.get(i), prefix[i]);
                    count.put(result[i], count.getOrDefault(result[i], 0) + 1);
                    unique = false;
                }
            }

            if (unique) {
                break;
            }
        }
        List<String> ans = new ArrayList<String>();
        for (String s : result) {
            ans.add(s);
        }
        return ans;
    }

    // p is the number of round
    private String getAbbr(String s, int p) {
        if (p + 2 >= s.length()) {
            return s;
        }
        String ans;
        // string add, the number will be converted to string automatically
        ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
        return ans;
    }
}