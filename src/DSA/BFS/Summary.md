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

// put BFS start point(s) into the queue
 q.offer();

// if in 2D matrix, use direction array
int[] dx = {0,1,0,-1};
int[] dy = {1,0,-1,0}
while(!q.isEmpty()) {

    // 如果需要算距离 先拿size 然后for loop
    // if you use for loop here, get the size first outside the loop
    
        q.poll(); // get your starting node
    
    //do something, like update, or just read data
    
    // put qualificated new start into the queue
    q.offer
}

```

