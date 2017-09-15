package DSA.Misc.UniqueWordAbbreviation;

import java.util.HashMap;

public class ValidWordAbbr {
    HashMap<String, String> dict;
    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<String, String>();
        for (String s : dictionary) {
            if (!dict.containsKey(toAbbr(s))) {
                dict.put(toAbbr(s), s);
            } else if (!dict.get(toAbbr(s)).equals(s)) {
                dict.put(toAbbr(s), "");
            }
        }
    }

    public boolean isUnique(String word) {
        if (!dict.containsKey(toAbbr(word))) {
            return true;
        } else if (dict.get(toAbbr(word)).equals(word)) {
            return true;
        }
        return false;
    }

    private String toAbbr(String src) {
        int n = src.length();
        if (n <= 2) {
            return src;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(src.charAt(0));
        sb.append(String.valueOf(src.length() - 2));
        sb.append(src.charAt(n - 1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */