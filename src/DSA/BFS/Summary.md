## BFS

## Concept:

就是就近一圈一圈搜索，好处是找到的时候知道了和原点最短的距离。

像是从原点蔓延



想清楚BFS的起点 可能是多个源点 或者边上行列

把这些点同时进Queue

### 应用场景

层序遍历 要size control

求最短距离

## Code temple:

```java
Queue<> q = new LinkedList<>;
// 注意 这里可用2个q来记录matrix上面的坐标移动xy
// put BFS start point(s) into the queue
 q.offer();
// 注意 这里可以只入q一个 也可以多个点同时入q

// if in 2D matrix, use direction array
// 如果输入是2D matrix 用这个来移动坐标
int[] dx = {0,1,0,-1};
int[] dy = {1,0,-1,0}
while(!q.isEmpty()) {
	// while了几次就是走过了几层 可以在这边count 距离
    // 如果需要算距离 先拿size,   然后这边可以放变量来level control 从走了多少步 或者这层发生了上面
    // 然后for loop 
    // if you use for loop here, get the size first outside the loop
    
        q.poll(); // get your starting node
    
    //do something, like update, or just read data
    
    // put qualificated new start into the queue
    q.offer
        
        
}

		int cx = qx.poll();
            int cy = qy.poll();
            for (int i = 0; i < 4; i++) {
                // new coordinate
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n
                        && matrix[nx][ny] >= matrix[cx][cy] + 1) {
                    matrix[nx][ny] = matrix[cx][cy] + 1;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }

```

练习题

Buses route

Sliding Puzzle

Kill process

zero one matrix