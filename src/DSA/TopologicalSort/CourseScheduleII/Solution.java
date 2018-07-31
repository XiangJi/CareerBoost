package DSA.TopologicalSort.CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/* follow up:
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * use int[] and k as index cursor
 */
class Solution {
    public int[] findOrder(int n, int[][] edges) {
        // build the graph list
        int[] res = new int[n];
        int[] degree = new int[n]; // 需要一格degree入度数组
        int count = 0; // 需要一格count来做TS最后的判断
        // 
        for (int[] edge : edges) {
            degree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        // Topogolical sort
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[count] = node;
            count++; // 每消除一格0点 在这边加count
            for (int[] edge : edges) {
                if (edge[1] == node) {
                    degree[edge[0]]--; //新点入度--
                    if (degree[edge[0]] == 0) { // 如果到1了加入
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        return count == n ? res : new int[0];
    }
}