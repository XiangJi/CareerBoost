# Dynamic programming

动态规划 记忆化搜索

动态规划是一种解决问题的思想：大规模问题的结果，是由小规模问题的结果运算得来的。

state的定义很重要

state transfer equation

初始化

结果

dp[n + 1] 0 —— n

return dp[n]

第一步要想： 最后一步怎么做



### 自底向上：Bottom up

从初始已知的状态出发，向外拓展，最后到达目标状态.

iterative approach

背包问题常用 最后可以通过滚动数组优化



### 自顶向下：Up to Bottom

从最终状态开始，找到可以到达当前状态的状态，如果该状态还没处理，就先处理该状态。

recursive approach,   use memoization 可以加速

动态规划可以用记忆化搜索递归实现

什么时候用up to bottom memoization呢？

1.状态转移特别麻烦，不是顺序性。

2.初始化状态不是很容易找到

常用于区间类问题和GameDP

### 应用场景：

需要多项式时间

1. 最大最小
2.  boolean 
3. count 计数

特点：输入无法sort或者swap不然无用

常见dp:

1. matrix dp  
2. 1D Sequence DP
3. 2d Sequence dp
4. Backpack 



最后用滚动数组空间优化

无后效性，意味着只要状态一致，具体经过怎样的步骤到达这一状态是没有影响的。

## Algorithm

1. 确定递归函数意义

    2. 确定大小范围，设计表  
    3. 确定递归终止状态，填表边界（自底向上时：从结尾填表；自顶向下时，跟踪递归流程填表）  例：  自底向上： 一般从dp[n] n>=边界处填表  自顶向下：一般根据跟踪递归从开始处例dp[0]填表  
    4. 确定要求的状态  
    5. 确定要求的状态与其所需依赖的状态关系（自底向上时：正向依赖; 自顶向下时：反向依赖）  例：  自底向上：f（i）=f（i+1） - >dp[i]=dp[i+1] （正向依赖）  自顶向下：f( i ) =f(i+1) - > dp[i] = dp[i-1]; （反向依赖）  
    6. 从要求的状态用依赖关系往下推，就可以发现规律  
    7. dp决策与递归相同可照抄  
    8. 最终就可以算出要求的dp状态（或者通过再次处理得出）





### Practice

Coin Change I II

Bomb Enemy

Burst Balloons

Decode ways

Predict the winner

NIM Game I II III

edit distance

几乎所有题都很重要 自己推一遍公式