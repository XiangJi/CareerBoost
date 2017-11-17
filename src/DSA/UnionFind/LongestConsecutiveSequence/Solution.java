package DSA.UnionFind.LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
     // brute force, sort and scan
     // Optimize, union find, search or merge disjoint set problem
    public int longestConsecutive(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int result = 0;
        for (int i : num) {
            set.add(i);
        }

        for (int i : num) {
            // for no duplicate search
            if (set.contains(i)) {
                set.remove(i);

                // two pointer
                int up = i + 1;
                int down = i - 1;

                while (set.contains(up)) {
                    set.remove(up);
                    up++;
                }

                while (set.contains(down)) {
                    set.remove(down);
                    down--;
                }
                result = Math.max(result, up - down - 1);
            }


        }
        return result;
    }
}