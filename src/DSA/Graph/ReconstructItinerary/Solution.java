package DSA.Graph.ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

1. BF: DFS input construct graph, 给一个点能知道它的链接,用hashmap<string,  sorted list<string>>
   remove 用过的边 backtrack
   O(N) + O(nLogn) + O(n!)<permutation>

2.  Graph theory: Eulerian path, sort, use priority queue
    有欧拉路径的条件， 一条环 每个点indegree = outdegree 或者 给一个 起点只有初度，终点只有入度，别的都有
    满足！
    Hierholzer 算法
    O(n) for the search

 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return null;
        }
        int total = tickets.length + 1; // total passed number of nodes
        HashMap<String, List<String>> map = new HashMap<>();
        // construct the graph, store with the hash
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        // sort the list destination
        for (List<String> list : map.values()) {
            Collections.sort(list); // no comparator needed
        }

        String start = "JFK";
        List<String> path = new ArrayList<>();
        path.add(start);
        if (dfs(start, path, total, map)) {
            return path;
        }
        return null;
    }

    // use boolean as a return value
    private boolean dfs(String start, List<String> path, int total, HashMap<String, List<String>> map) {
        if (path.size() == total) {
            return true;
        }

        // prune invalid search
        if (!map.containsKey(start)) {
            return false;
        }
        List<String> destination = map.get(start);

        // search in the start
        for (int i = 0; i < destination.size(); i++) {
            String dest = destination.get(i);
            // we can only use the node once, so remove
            destination.remove(i);
            path.add(dest);
            if (dfs(dest, path, total, map )) {
                return true;
            }
            // if not found, backtrack, and add back this node
            path.remove(path.size() - 1);
            destination.add(i, dest);
        }
        return false;
    }
    // Hierholzer for Eularian path
    // dfs from path, push left
    public List<String> findItineraryII(String[][] tickets) {
        if (tickets == null) {
            if (tickets == null || tickets.length == 0) {
                return null;
            }
        }
        // use linkedlist, because hierholzer push to the left
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();

        // construct the graph by map
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
        search("JFK", result, map);
        return result;
    }

    private void search(String start, LinkedList<String> result, HashMap<String, PriorityQueue<String>> map) {
        PriorityQueue<String> q = map.get(start);
        while (q != null && !q.isEmpty()) {
            search(q.poll(), result, map);
        }
        result.addFirst(start);
    }

}
