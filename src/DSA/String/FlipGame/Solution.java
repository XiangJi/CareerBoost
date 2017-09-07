package DSA.String.FlipGame;

import java.util.ArrayList;
import java.util.List;

// base question for flip game 2, can use char array to implement
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length()== 0) {
            return result;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder temp = new StringBuilder(s);
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                temp.setCharAt(i, '-');
                temp.setCharAt(i + 1, '-');
                result.add(temp.toString());
            }
        }
        return result;
    }
}