package DSA.Array.ValidWordSquare;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                // make the not to index out of bound, the first two method can really get value
                if (j >= words.size() || i >=  words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}