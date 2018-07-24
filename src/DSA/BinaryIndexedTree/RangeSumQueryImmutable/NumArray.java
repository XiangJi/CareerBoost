package DSA.BinaryIndexedTree.RangeSumQueryImmutable;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

Prefix sum, if changed, use binary index tree

BIT
 */
public class NumArray {
    int[] nums;
    int[] tree;
    int n;

    // time : O(n * logn)
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    // time : O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
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