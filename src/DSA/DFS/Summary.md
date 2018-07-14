# DFS

## Concept

DFS分为枚举型，分治型 和在图上面搜索，

枚举型常见于暴力搜索，回溯遍历。

分治型常见于二叉树分类处理 其实本质也是正常dfs只不过call两个children的dfs

图上搜索就是用dfs的遍历方式在图上面做操作



枚举型dfs如果定长 就是n个for循环，因为长度不定，所以用递归实现

也可以用stack手动模拟 但是太难写没人这么做

三种记录中间状态的选择，第几层，现在的这层的结果，输入，全部结果

递归实现方便

1. 很多临时变量可以去放在dfs的参数里面

2. 不变的拿来当输入的可以放在member variable 比如count是primitiive 必须放在外面 和输入arraylist

3. 想清楚dfs的返回值用什么 一般是boolean 这个flag也可以放在参数里面 但是放在返回值里面好看

   

dfs+pruning 剪枝就是去冗余

## Code template

先写dfs函数 退出条件后写 想清楚是最后还是最前

### Backtracking

When solving a backtracking problem, pay attention to whether it’s a Permutation problem, or a Combination.

A general recursive template for backtracking may look like this:

```java
/*可以用的参数 
 * input list, 输入一般都要传进去 可以是list或者string
 * temp list， 当需要存储temp结果 最后加入到res里面使用
 * 当结果只能用一次时候使用 visited (hash or boolean array), permutation一般需要
 * cursor index 一般都会需要 除非在树上面, 意义是这轮search的start cursor, permutationb不需要这个 直接从0开始就行
 * res list, 当需要求全部结果的时候使用
 * 用于计算的value(e.g. remain - see combination sum)
 * Memoization: 拿一个cache来存储结果 这样可以提前返回 剪枝
 
 * 可用的返回值 boolean 或者int 这种时候一般可以用cache加速 一般不是穷举所有值 而是求一个boolean或者int的时候 就需要把它变成返回值
 
 * 
 */
	dfs (parameters of given data and current recursive level) {
        // Handle base cases, i.e. the last level of recursive call
        // 退出条件 return一定不要忘记写
        if (root == null) {
                return;
        }
        // 提前退出条件 或者一定的对这个定点的条件操作
       		if (level == lastLevel) {
            record result;
             // result.add(new ArrayList<Integer>(tmp)); 一般用深拷贝
            return sth;
        	}
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        // Otherwise permute every possible value for this level.
        for (every possible value for this level, maybe i = index) {
            // 满足某个条件吗
            // 比如处理有duplicate的情况 
            //i > pos && candidates[i] == candidates[i - 1], then continue
            if (condition)  
            {
                tmp.add(candidates[i]);
                used..;
                //确定给下一层的数据
                //如果我们可以一直用同一个数的时候i不需要+1
                // 如果index只能用一次 + 1
                dfs(i + 1, used, input, temp); 
                
                
                delete the last;
                tmp.remove(tmp.size() - 1); //删掉最后一个
             
            } 
            
        }
        return sth;
    }
    
    
如果你已经找到了解决方案，那么返回成功
for(现在位置可以的所有可能选择）｛
  选择其中一个方案然后沿着路径前进一步
  使用递归的方法从新的位置解决问题
  如果新的位置可以成功解决，向上一级返回成功
  从现在位置恢复到循环之前的位置
 ｝
 如果到这里表示仍然没有成功，返回失败


```
T(n) = T(n-1)+T(n-2)+…+T(1)      ---O(2^n)     Space --O(n)  combination

T(n - 1) = T(n - 2) + .. T(1) 带入后

T(n) = 2 ^ n * T(1)

subset：
时间复杂度：递归被调用的次数应该和解的个数是一样的，所以总共递归了2^n次，每次递归里面有个for循环所以是O(n)时间，那么时间复杂度是O(n*2^n)
空间复杂度：应该跟调用递归次数一样O(2^n)

T(n) = n * T(n-1)  O(n!)  O(n)  permutation  



permutation:
时间复杂度：递归被调用的次数与解的个数一样是n!次，每次有个for循环，那么总时间复杂度是O(n*n!)
空间复杂度：与调用递归次数一样O(n!)

计算复杂度的公式 `O(构造解的复杂度 * 解的个数)` 

### Graph DFS

```java
public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return null;
        }
    	// 输入是edges 先把它变成adjacency list
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


在matrix上面直接dfs 看word search，找四个方向
```



### Tree DFS

Please see content in Tree summary

## Practice

练得越多就越熟练

Longest Increasing Path in a Matrix 

Cracking the safe

Expression add operation 变形 四则运算和括号 看能不能得到目标值 

升级版是24Game 如何构造这些dfs场景和条件变量



Generate abbreviations

FlipGameII

Pyramid

ReconstructItinerary

WordSearch I II