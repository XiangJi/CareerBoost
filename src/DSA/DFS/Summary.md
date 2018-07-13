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
//可以用的参数 input list, temp list, visited (map or array), dfs cursor index 
	dfs (parameters of given data and current recursive level) {
        // Handle base cases, i.e. the last level of recursive call
        // 退出条件 
        if (level == lastLevel) {
            record result;
            return sth;
        }
        // Optional: 提前退出条件 或者一定的对这个定点的条件操作
       
        // Otherwise permute every possible value for this level.
        for (every possible value for this level) {
            if (condition) // 满足某个条件吗 
            {
                add..;
                used..;
                dfs(index + 1, used, input, temp); //确定给下一层的数据
                delete the last;
                used remove;
             
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



### Tree DFS

Please see content in Tree summary

## Practice

练得越多就越熟练

Longest Increasing Path in a Matrix 