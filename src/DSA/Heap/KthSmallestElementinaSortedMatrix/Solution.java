package DSA.Heap.KthSmallestElementinaSortedMatrix;

import java.util.PriorityQueue;

/*
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

BF: put all item's in heap then heap size > k, pop

1. 1 - 5 -9 先放进去 然后row提升放入 每次pop最小的数
2. Use binary search & count min = 1 max = 15 mid = 8找比8小的数
 */
public class Solution {
    //// time : (nlogn) space : O(n)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        // pop out k - 1 element
        for (int i = 0; i < k - 1; i++) {
            Tuple current = pq.poll(); // 每次拿出最小的数 然后做列切换
            if (current.x == matrix.length - 1) {
                continue;
            }
            pq.offer(new Tuple(current.x + 1, current.y, matrix[current.x + 1][current.y]));
        }
        return pq.poll().val;

    }

    // time : O(n * log(max - min)) space : O(1)
    public int kthSmallestII(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);
            if (num >= k)
                right = mid;
            else
                left = mid;
        }
        if (count(matrix, right) <= k - 1)
            return right;
        return left;
    }

    // count implementation记一下
    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0; //从左下角开始search
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else
                i--;
        }
        return res;
    }
}

class Tuple {
    int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

}
