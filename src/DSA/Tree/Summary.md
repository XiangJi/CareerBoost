# Tree

Most of them can be solved by Divide and conquer, DFS(recursive), BFS



DFS BFS

stack queue iterative solution\

1. 选遍历方式  
   1. preorder 从上到下 <总常用>

      Do you determine some parameters to help the node know the answer of itself? Can you use these parameters and the value of the node itself to determine what should be the parameters parsing to its children?

      利用自己定义的参数和node的结果 往下传

      ```java
      <tmp, max, target number > //dfs层之间比较 用next 或者prev args
          min max 根据物理意义确定初始化是MAX MIN or 0
      ```

      

   2. inorder从左到右  <常用在BST，BST的inorder遍历从小到大，反中根降序>

   3. postorder从下到上比较 <用于子模块操作 常用于subtree 也可能和层数有关>

      Or you can think the problem in this way: for a node in a tree, if you know the answer of its children, can you calculate the answer of the node?

      知道子的结果能不能求根的结果？

   4. BFS size要用于控制每个层数的个数 没有得话也是level order 但是不知道每层有多少个

   5. Divide and conquer两边同时往下走 双preorder 很多时候不需要helper
2. 选recursive和iterative
3. 套模板 special 用dfs来实现levelorder 用一个int来track level， 看right side view那题

```java
public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left); 
            res.add(cur.val);
        }
        return res;
    }

public List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

public List<Integer> postorderTraversalII(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>(); // trick linked list
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val); // trick
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
```



Construct tree from data: use start end cursor from array 是基本模板 能画能讲

Serilize and deserilze 操作要熟 是基本模板



BST 和二分法的思想一样

二分法问了logN search —加入logN插入删除—> BST—平衡时候logN,不平衡时候就是N—> 平衡树 



自己想办法构建递归：

想传参应该是什么 boolean？ int? int[]

well defined your recursive method first!

what does it return?

what tasks does it do?

For this tasks, what's the order?

recursive first, or operation first?

Do not test it, think if correct first!



### Practice 

Binary Tree Longest Consecutive Sequence I, II