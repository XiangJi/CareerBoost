package DSA.BFS.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 有向有权值有环的连通图中找初始点到给定目的点的最短距离，follow up是给出初始点到所有点的最短距离
 *
 *克斯特拉算法使用了廣度优先搜索解决赋权有向图的单源最短路径问题。该算法存在很多变体；戴克斯特拉的原始版本找到两个顶点之间的最短路径，但是更常见的变体固定了一个顶点作为源节点然后找到该顶点到图中所有其它节点的最短路径，产生一个最短路径树。该算法常用于路由算法或者作为其他图算法的一个子模块。举例来说，如果图中的顶点表示城市，而边上的权重表示城市间开车行经的距离，该演算法可以用来找到两个城市之间的最短路径。
 *
 *
 *Dijkstra's algorithm is based on repeatedly making the candidate move that has the least distance travelled.
 *
 *In our implementations below, we showcase both O(N^2)O(N
​2
​​ ) (basic) and O(N \log N)O(NlogN) (heap) approaches.

Graph use 2d Matrix present

與 Dijkstra 算法不同，Bellman-Ford算法可用於具有負花費邊的圖，只要圖中不存在總花費為負值且從源點 s 可達的環路（如果有這樣的環路，則最短路徑不存在，因為沿環路循環多次即可無限制的降低總花費）。在可能有环路的情况下，Bellman-Ford算法则可以通过检测程序while循环次数是否大于|V|来进行判断。

與最短路徑問題相關最有名的一個問題是旅行商問題，此類問題要求找出恰好通過所有目標點一次且最終回到原點的最短路徑。然而該問題為NP-完全的；換言之，與最短路徑問題不同，旅行商問題不太可能具有多項式時間解法。

如果有已知信息可用來估計某一點到目標點的距離，則可改用A*搜尋算法，以減小最短路徑的搜索範圍。

Heap<Point, dist> + 2  Map, V- parente, V - Dist
https://www.youtube.com/watch?v=lAXZGERcDf4

 * Find single source shortest path using Dijkstra's algorithm
 *
 * Space complexity - O(E + V)
 * Time complexity - O(ElogV)
 *
 * References
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 * 
 * 
 * There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.

 * CLRS book*/
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
}