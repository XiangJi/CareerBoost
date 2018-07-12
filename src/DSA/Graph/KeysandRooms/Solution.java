package DSA.Graph.KeysandRooms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.

一系列的房间 看房间能不能走遍
dfs bfs 都可以做

DFS: check all nodes visited

Input adjacency list
 */
public class Solution {
    // DFS,这里输入必须是list 不然没法pass
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);
        return visited.size() == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, HashSet<Integer> visited, int index) {
        // exist
        if (visited.contains(index)) {
            return;
        }
        visited.add(index);
        // search
        for (int key : rooms.get(index)) {
            if (!visited.contains(key)) {
                dfs(rooms, visited, key);
            }
        }
    }

    // BFS the same check all nodes visited
    public boolean canVisit(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            visited.add(room);
            for (int key : rooms.get(room)) {
                if (!visited.contains(key)) {
                    queue.offer(key);
                }
            }
        }
        return visited.size() == rooms.size();

    }

}