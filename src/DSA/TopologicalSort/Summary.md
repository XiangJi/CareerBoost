# Topological Sort

## Concept

在图论中，由一个有向无环图的顶点组成的序列，当且仅当满足下列条件时，称为该图的一个拓扑排序（英语：Topological sorting）。

1. 每个顶点出现且只出现一次；
2. 若A在序列中排在B的前面，则在图中不存在从B到A的路径。

也可以定义为：拓扑排序是对有向无环图的顶点的一种排序，它使得如果存在一条从顶点A到顶点B的路径，那么在排序中B出现在A的后面

有向无环图（DAG）才有拓扑排序，非DAG图没有拓扑排序一说 

所以说会找拓扑排序，找不到就说明有环

在一个DAG里面 判断是否有闭环，有的话就无法TS

### Fact

一般来说拓扑排序不一定只有一种。 比如这道题拓扑排序就有[0, 1, 2, 3, 4, 5]， [0, 2, 3, 1, 5, 4] 等

入度的意思是有向图中，一个点有N个边指向这个点，那么它的入度就是N， 比如题中1的入度就是1，4的入度就是2

出度度的意思是有向图中，一个点有N个边指向其他的点，那么它的出度就是N， 比如题中0的入度就是3，2的入度就是2



应用场景：

有向图找环 或者有向图看能不能输出最终的拓扑排序

## Algorithms: BFS 和DFS

都可以做， 复杂度是O（n + e） ~ O（b^d）



DFS
利用dfs遍历图 。 节点分白、灰、黑三色。开始都是白色，当开始访问某节点时该节点变为灰色，当该节点的所有邻接点都访问完，该节点颜色变为黑色。如果遍历的过程中发现某个节点的neigbor为灰色的节点，则有环。
注意用recursive的方式。

BFS 

1. 从有向图中选取一个入度为0的node，加入order的list 或者所有入度为0的点进queue

2. 从有向图中删去此node，与其相连的所有node的度减1

3. 如果这个点入度变成0或者1重新进queue

4. 重复上述两步，直至图空，或者图不空但没有度为0的节点。

// 如果该图是一个有向无环图，则最后拓扑排序一定能遍历所有点，否则不是。

5.最后判断用一个count来比较和总共应有节点的大校





对于拓扑排序来说， 我们的中心思想是要我们可以找到一个顺序，每一次我们可以进行的工序是现在没有先序依赖的工序，按照这个顺序可以流畅的完成我们的任务。

## Code template

```java
//BFS
public <Output sequence> findTS(int numNodes, int[][] edges) {
    int[] degree = new int[numNodes];
    int[] res = new int[numNodes];
    int k = 0; // used as a cursor
    // 如果输入不够直观 需要重新用hashmap<node, set<node>> 构图 再从hashmap图中构建
    
    // init iterate through the edges, update degree for each node
    for (int[] edge : edges) {
            indegree[edge[0]]++;
        }
    // put all the node with degree 0 in to the queue
    // , 如果没有明显起点 先把所有degree变为1， 然后update degree 再从所有这些点==1开始的点开始
    for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
    }
    
    // BFS 拿出当前节点然后操作
    while (!queue.isEmpty()) {
        int pre = queue.poll();
        	// operation 如果图不是raw的自己用map去简历
            for (int[] edge : edges) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
    }
    
    // validate the res and return 最后比较大小对不对
    return (k == numCourses) ? res : new int[0];
    
}

// DFS white grey black
public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }
	// unvisited, visiting, visited
    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;
        for (int nei: graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }

        color[node] = 2;
        return true;
    }
```

