package DSA.String.FlipGame;

import java.util.ArrayList;
import java.util.List;

/*
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
 */
// base question for flip game 2, can use char array to implement
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
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