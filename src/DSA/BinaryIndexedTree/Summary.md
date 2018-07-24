# BIT

## Concept

线段树和树状数组的基本功能都是在某一满足结合律的操作(比如加法，乘法，最大值，最小值)下，O(logn)的时间复杂度内修改单个元素并且维护区间信息。

A **Fenwick tree** or **binary indexed tree** is a data structure that can efficiently update elements and calculate [prefix sums](https://link.jianshu.com/?t=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FPrefix_sum) in a table of numbers.

把计算结果分散到不同节点上去 然后combine得到结果

![img](http://zxi.mytechroad.com/blog/wp-content/uploads/2018/01/sp3-2.png)

#### Update tree

i += lowbit(i), lowbit(x) = x & (-x), 每个点一直update自己的lowbit，lowbit就是自己的最后一位1形成的数

#### Query Tree

i -= lowbit(i)

Example:前7个sum是10+11+7 =28

高度是logN



树状数组没有明确的二分结构，只有类似于前缀和的结构，长这样：

bit的要求：有逆元，满足交换律和结合律
线段树的要求：有了结合律就可以！



![img](https://pic2.zhimg.com/80/v2-4101631f7794c589bda2fea072c49adf_hd.jpg)



### Code template

```java
public class NumArray {
    int[] nums;
    int[] tree;
    int n;

    // time : O(n * logn)
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n]; // 注意初始化一定要是new
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    // time : O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val; // 赋值
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    // time : O(logn)
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}

2D mutable 就是2D的 练习code写一遍
```

