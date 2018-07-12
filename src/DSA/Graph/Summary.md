# Graph

https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs

### Adjacency lists 

一般这种时候不在matrix上面 就是在用hashmap构图 

![img](https://ka-perseus-images.s3.amazonaws.com/cc82379521bd84738e86d6cf9552738ca9138420.png)

```
[ [1, 6, 8],
  [0, 4, 6, 9],
  [4, 6],
  [4, 5, 8],
  [1, 2, 3, 5, 9],
  [3, 4],
  [0, 1, 2],
  [8, 9],
  [0, 3, 7],
  [1, 4, 7] ]
```

这种时候就是在用hashmap构图





![img](https://ka-perseus-images.s3.amazonaws.com/21cd2731928c7c13057eee000e3697de82ccc058.png)

### Edge lists

图一般用edge list int[][] edges 来表示

```
[ [0,1], [0,6], [0,8], [1,4], [1,6], [1,9], [2,4], [2,6], [3,4], [3,5],
[3,8], [4,5], [4,9], [7,8], [7,9] ]
```

### Matrix

直接一个matrix上面用数字表示东西 可以直接用





### Adjacency matrices

![img](https://ka-perseus-images.s3.amazonaws.com/549bca1a52774846b25caff86d244d03ee63fd38.png)

```
[ [0, 1, 0, 0, 0, 0, 1, 0, 1, 0],
  [1, 0, 0, 0, 1, 0, 1, 0, 0, 1],
  [0, 0, 0, 0, 1, 0, 1, 0, 0, 0],
  [0, 0, 0, 0, 1, 1, 0, 0, 1, 0],
  [0, 1, 1, 1, 0, 1, 0, 0, 0, 1],
  [0, 0, 0, 1, 1, 0, 0, 0, 0, 0],
  [1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1],
  [1, 0, 0, 1, 0, 0, 0, 1, 0, 0],
  [0, 1, 0, 0, 1, 0, 0, 1, 0, 0] ]
```





