package DSA.DFS.FlipGameII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

2 ^ N ? N! ? N!!

这题的hashmap是加速用的
 */
public class Solution {

    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // captial Boolean as type, not need to be a global variable
        HashMap<String, Boolean> map = new HashMap<>();
        return dfs(s, map);
    }

    private boolean dfs(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                // substring can only has start index then default the end
                String other = s.substring(0, i) + "--" + s.substring(i + 2);
                // recursion
                if (!dfs(other, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
    // not optimized yet
    public boolean canWinII(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));         // generate all possible sequence after every attempt
        }
        /*if(list.isEmpty())
            return false;*/
        for(String str : list){
            if(!canWin(str))             // if there is any one way the next player can't win, take it and you'll win
                return true;
        }
        return false;
    }
}