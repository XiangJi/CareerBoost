package DSA.Graph.CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * G. F
 *
 * BFS, DFS
 * T: O( E + V) V:Node E: Edge
 * S: O(V)
 */
public class Solution {
    // DFS
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // create and store cloned node
        UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        map.put(node, dup);
        // copy neighbors
        for (UndirectedGraphNode neighbor : node.neighbors) {
            dup.neighbors.add(dfs(neighbor));
        }
        return dup;
    }

    // BFS
    public UndirectedGraphNode cloneGraphII(UndirectedGraphNode root) {
        if (root == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        // queue is used for helping BFS, map for storing the node mapping between the old/clone graphs
        queue.offer(root);
        map.put(root, new UndirectedGraphNode(root.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // to the next level
                    queue.offer(neighbor);
                    // clone the neighbor
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                // clone the neighbor for current node
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(root);
    }

}