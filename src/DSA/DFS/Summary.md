# DFS

DFS分为枚举型和分治型，枚举型常见于暴力搜索，回溯遍历。分治型常见于二叉树分类处理



枚举型dfs如果定长 就是n个for循环，因为长度不定，所以用递归实现

也可以用stack手动模拟

三种记录中间状态的选择，第几层，现在的这层的结果，输入，全部结果

递归实现方便

1. 全放dfs
2. 不变的放在成员变量里 不推荐
3. 改变的数组也可以放在成员变量里，用stack手动模拟，java里面不推荐

Template



先写dfs函数

if exit_condition {

return;

}

for （）{

dfs()

}

 

推出条件后写 想清楚是最后还是最前



dfs+pruning 剪枝就是去冗余

When solving a BT problem, pay attention to whether it’s a Permutation problem, or a Combination.



I would say `Practice Makes Perfect`.

A general recursive template for backtracking may look like this:

```
   helper (parameters of given data and current recursive level) {
        // Handle base cases, i.e. the last level of recursive call
        if (level == lastLevel) {
            record result;
            return sth;
        }
        // Otherwise permute every possible value for this level.
        for (every possible value for this level) {
            helper(parameters of given data and next recursive level);
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
dfs要自己多写多练

subset：
时间复杂度：递归被调用的次数应该和解的个数是一样的，所以总共递归了2^n次，每次递归里面有个for循环所以是O(n)时间，那么时间复杂度是O(n*2^n)
空间复杂度：应该跟调用递归次数一样O(2^n)

permutation:
时间复杂度：递归被调用的次数与解的个数一样是n!次，每次有个for循环，那么总时间复杂度是O(n*n!)
空间复杂度：与调用递归次数一样O(n!)

计算复杂度的公式 `O(构造解的复杂度 * 解的个数)` 