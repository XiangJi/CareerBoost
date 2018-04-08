package DSA.DFS.FactorCombinations;

import java.util.ArrayList;
import java.util.List;

/*
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Linkedin
 */
class Solution {
    public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (n < 3) {
            return result;
        }
        dfs(result, new ArrayList<Integer>(), 2, n);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int start, int remain) {
        // exsit: remain == 1, also exclude the corner case
        if (remain == 1) {
            // corner case, [n] is not qualified
            if (path.size() != 1) {
                result.add(new ArrayList<Integer>(path)); // deep copy
            }
            return; // never forget the return, write it first
        }
        
        // path is actully the stack, dfs and backtracking
        for (int i = start; i <= remain; i++) {
            /*prune the unnecessary dfs calls
             * if (i * i > remain) {
             *     break;
             *  }
             * 
             */
            if (remain % i == 0) {
                path.add(i);
                dfs(result, path, i, remain / i);
                path.remove(path.size() - 1);
            }
        }
        /*
         * path.add(remain);
         * dfs(result, path, remain, 1);
         * path.remove(path.size() - 1);
         */
    }
}