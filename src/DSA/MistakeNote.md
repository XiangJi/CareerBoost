# Mistake Note

logic最重要 不要背诵 要分析思路

说明算法

面试的时候闲聊自己bring up topic带节奏，不给对方节奏走

多练习基础算法：形成大脑肌肉记忆 2合一的难题才可以写出来

不熟就不敢去想，要熟

 现场debug不要怕，肉眼看，debug 跑test也加分

四大算法：模拟，搜索枚举，图论，动态规划（都结合数据结构）

int不能和null做比较判断

做完题先自己用肉眼 debug 不要就想一遍过去依赖complier

List<List<Integer>> result = new ArrayList<List<Integer>>();

Queue<TreeNode> queue = new LinkedList<TreeNode>();

Time complexity of recursion algorithm: o(branch ^ depth)

O(n) 可以是多次遍历

Arrays.sort()

如果我们的递归函数的参数和返回值 与 给出的函数的参数和返回值已知，那么我们可以直接递归调用自己。

以下几种情况是需要写一个Helper方法的。
\1. 递归的时候需要更多的参数
\2. 递归的返回数据类型与给出函数的返回数据类型不同
\3. 递归操作前需要做数据预处理的
\4. 递归结束后，所得结果需要再次加工的

Design 题目 Java constuctor是拿来初始化的， 成员变量的定义应该在构造器的外面，Example: LC288

size = size, ——X, dead assignment

== 和 = 不要写错

记得初始化变量

