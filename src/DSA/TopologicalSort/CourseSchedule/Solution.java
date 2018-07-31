package DSA.TopologicalSort.CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.

有向图,找路径遍历所有点，如果有环就不行吗，无法完成拓扑排序，也就不可能修完所有的课程。
DFS， BFS都可以做
T: O(V+E)

先找入度为0的点
一位数组in来表示每个顶点的入度。我们开始先根据输入来建立这个有向图，
并将入度数组也初始化好。然后我们定义一个queue变量，将所有入度为0的点放入队列中，然后开始遍历队列，
从graph里遍历其连接的点，每到达一个新节点，将其入度减一，如果此时该点入度为0，则放入队列末尾。
直到遍历完队列中所有的值，
若此时还有节点的入度不为0，则说明环存在，返回false，反之则返回true。
最后看是否有遍历所有点

DFS BFS 两种实现最好都掌握
 */
class Solution {
    public boolean canFinish(int n, int[][] edges) {
        // build the graph list
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
        return count == n;
    }
}