package DSA.BFS.RaceCar;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)

Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).

When you get an instruction "A", your car does the following: position += speed, speed *= 2.

When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)

For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.

Now for some target position, say the length of the shortest sequence of instructions to get there.

Example 1:
Input:
target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0->1->3.
Example 2:
Input:
target = 6
Output: 5
Explanation:
The shortest instruction sequence is "AAARA".
Your position goes from 0->1->3->7->7->6.

 * ell, the BFS solution is straightforward: we can keep track of all the possible positions of the racecar after n instructions (n = 0, 1, 2, 3, 4, ...) and return the smallest n such that the target position is reached. Naive BFS will run at O(2^n) since for each position we have two choices: either accelerate or reverse. Further observations reveal that there may be overlapping among intermediate states so we need to memorize visited states (each state is characterized by two integers: car position and car speed). However, the total number of unique states still blows up for large target positions (because the position and speed can grow unbounded), so we need further pruning of the search space.
 */
public class Solution {
    public int racecar(int target) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[] {0, 1}); // starts from position 0 with speed 1

        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);

        for (int level = 0; !queue.isEmpty(); level++) {
            for(int k = queue.size(); k > 0; k--) {
                int[] cur = queue.pollFirst();  // cur[0] is position; cur[1] is speed

                if (cur[0] == target) {
                    return level;
                }

                int[] nxt = new int[] {cur[0] + cur[1], cur[1] << 1};  // accelerate instruction
                String key = (nxt[0] + " " + nxt[1]);

                if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
                    queue.offerLast(nxt);
                    visited.add(key);
                }

                nxt = new int[] {cur[0], cur[1] > 0 ? -1 : 1};  // reverse instruction
                key = (nxt[0] + " " + nxt[1]);

                if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
                    queue.offerLast(nxt);
                    visited.add(key);
                }
            }
        }

        return -1;
    }
}
