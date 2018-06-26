# Tree

Most of them can be solved by Divide and conquer, DFS(recursive), BFS



DFS BFS

stack queue iterative solution

1. 选遍历方式  
   1. preorder 从上到下 <总常用>
   2. inorder从左到右  <常用在BST，BST的inorder遍历从小到大，反中根降序>
   3. postorder从下到上比较 <用于子模块操作 常用于subtree 也可能和层数有关>
   4. BFS size要用于控制每个层数的个数 没有得话也是level order 但是不知道每层有多少个
   5. Divide and conquer两边同时往下走 双preorder 很多时候不需要helper
2. 选recursive和iterative
3. 套模板 special 用dfs来实现levelorder 用一个int来track level， 看right side view那题







BST 和二分法的思想一样

二分法问了logN search —加入logN插入删除—> BST—平衡时候logN,不平衡时候就是N—> 平衡树 



BST 问题 分类讨论 分而治之

use recursive

well defined your recursive method first!



what does it return?

what tasks does it do?

For this tasks, what's the order?

recursive first, or operation first?

Do not test it, think if correct first!

