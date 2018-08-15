package DSA.DynamicProgramming.FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*
 *
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
 */
public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();// store position and last junmp can reach here
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            int pos = stones[i];
            for (int k : map.get(pos)) {
                for (int j = k - 1; j <= k + 1; j++) {
                    if (j > 0 && map.containsKey(pos + j)) {
                        map.get(pos + j).add(j);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}