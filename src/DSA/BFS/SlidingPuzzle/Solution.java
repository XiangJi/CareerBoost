package DSA.BFS.SlidingPuzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14

华容道问题 用BFS可以做 最优解A*不用管
Use 0 to swap with its neighbors

T:S o((n * m)!)

这道题好就好在限定了棋盘的大小，是2x3的，这就让题目简单了许多，由于0的位置只有6个，我们可以列举出所有其下一步可能移动到的位置。
为了知道每次移动后拼图是否已经恢复了正确的位置，我们肯定需要用个常量表示出正确位置以作为比较，那么对于这个正确的位置，
我们还用二维数组表示吗？也不是不行，但我们可以更加简洁一些，就用一个字符串 "123450"来表示就行了，
注意这里我们是把第二行直接拼接到第一行后面的，数字3和4起始并不是相连的。好，下面来看0在不同位置上能去的地方，字符串长度为6，
则其坐标为 012345，转回二维数组

回二维数组为：

0  1  2
3  4  5

 */
public class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();
        // all the positions 0 can be swapped to
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                // swap if possible
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);

                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] start = new int[][] { { 1, 2, 3 },
                { 4, 0, 5 } };
        Solution test = new Solution();
        System.out.println(test.slidingPuzzle(start));
    }
}
