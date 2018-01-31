# Segment tree

线段树是一棵二叉树, 平常我们所指的线段树都是指一维线段树。 故名思义, 线段树能解决的是线段上的问题, 这个线段也可指区间.
我们先来看线段树的逻辑结构。

一颗线段树的构造就是根据区间的性质的来构造的, 如下是一棵区间[0, 3]的线段树，每个[start, end]都是一个二叉树中的节点。

          [0,3]
         /     \
    [0,1]       [2,3]
    /   \       /   \
    [0,0] [1,1]  [2,2] [3,3]
![img](https://pic3.zhimg.com/80/v2-1b02ce4d668e7aa0bd173d69c5a63566_hd.jpg)

区间的第三维就是区间的最大值。
加这一维的时候只需要在建完了左右区间之后，根据左右区间的最大值来更新当前区间的最大值即可，即当前子树的最大值是左子树的最大和右子树的最大值里面选出来的最大值。

因为每次将区间的长度一分为二,所有创造的节点个数，即底层有n个节点，那么倒数第二次约n/2个节点，倒数第三次约n/4个节点，依次类推：

    n + 1/2 * n + 1/4 * n + 1/8 * n + ...
    =   (1 + 1/2 + 1/4 + 1/8 + ...) * n
    =   2n

所以构造线段树的时间复杂度和空间复杂度都为O(n), 查询是O(log(n)),结合了二叉树二分的数据结构

线段树中的Node如何定义:

```
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max
        this.left = this.right = null;
    }
}
```

```
public SegmentTreeNode build(int[] A) {
    // write your code here
    return buildhelper(0, A.length - 1, A);
}

public SegmentTreeNode buildhelper(int left, int right, int[] A){
    if(left > right){
        return null;
    }
    SegmentTreeNode root = new SegmentTreeNode(left, right, A[left]); // 根据节点区间的左边界的序列值为节点赋初值
    if(left == right){
        return root; // 如果左边界和右边界相等,节点左边界的序列值就是线段树节点的接节点值
    }
    int mid = (left + right) / 2; // 划分当前区间的左右区间
    root.left = buildhelper(left, mid, A);
    root.right = buildhelper(mid + 1, right, A);
    root.max = Math.max(root.left.max, root.right.max); // 根据节点区间的左右区间的节点值得到当前节点的节点值
    return root;
}
```

**举一反三：**
如果需要区间的最小值:
`root.min = Math.min(root.left.min, root.right.min);`
如果需要区间的和:
`root.sum = root.left.sum + root.right.sum;`



线段树的更新

```
// 单点更新的代码及注释
public void modify(SegmentTreeNode root, int index, int value) {
    // write your code here
    if(root.start == root.end && root.start == index) { // 找到被改动的叶子节点
        root.max = value; // 改变value值
        return ;
    }
    int mid = (root.start + root.end) / 2; // 将当前节点区间分割为2个区间的分割线
    if(index <= mid){ // 如果index在当前节点的左边
        modify(root.left, index, value); // 递归操作
        root.max = Math.max(root.right.max, root.left.max); // 可能对当前节点的影响
    }
    else {            // 如果index在当前节点的右边
        modify(root.right, index, value); // 递归操作
        root.max = Math.max(root.left.max, root.right.max); // 可能对当前节点的影响
    }
    return ;
}
```

Segment Tree解题构造比较复杂，一般它的问题都可以用树状数组BIT来解决。 直接用树状数组。